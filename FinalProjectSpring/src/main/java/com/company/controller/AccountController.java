package com.company.controller;

import com.company.dto.ApplicationDTO;
import com.company.entity.Receipt;
import com.company.entity.Role;
import com.company.entity.User;
import com.company.exceptions.TransactionException;
import com.company.service.ApplicationService;
import com.company.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/account")
public class AccountController {

    private final UserService userService;
    private final ApplicationService applicationService;

    public AccountController(UserService userService, ApplicationService applicationService) {
        this.applicationService = applicationService;
        this.userService = userService;
    }

    @GetMapping
    public String mainPage(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        if (user.getAuthorities().contains(Role.ADMIN)) {
            model.addAttribute("admin", true);
        } else {
            model.addAttribute("admin", false);
        }
        return "user_page";
    }

    @GetMapping("/application")
    public String getUserAccount() {
        return "application_page";
    }

    @PostMapping("/application")
    public String makeApplication(@AuthenticationPrincipal User user,
                                 @Valid ApplicationDTO applicationDTO,
                                 BindingResult bindingResult,
                                 Model model,
                                 HttpSession session) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("applicationDTO", applicationDTO);
            return "application_page";
        } else {
            applicationService.addApplication(applicationDTO);
            applicationService.addReceiptToSession(applicationService.createReceipt(user), session);
        }
        return "redirect:/account/application";
    }

    @GetMapping("/all_users")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String showAllUsers() {
        return "users";
    }

    @GetMapping("/shopping_basket")
    public String getReceiptsPage(@RequestParam(name = "error", required = false) String error,
                                  @RequestParam(name = "success", required = false) String success,
                                  Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("success", success != null);
        return "shopping_basket";
    }

    @PostMapping("/save/{index}")
    public String save(@PathVariable int index, HttpSession session) {
        Receipt receipt = applicationService.getReceiptFromSession(index, session);
        try {
            applicationService.sendMoney(userService.getCurrentUser(), receipt);
            applicationService.deleteReceiptFromSession(receipt, session);
        } catch (TransactionException e) {
            e.printStackTrace();
            return "redirect:/account/shopping_basket?error";
        }
        return "redirect:/account/shopping_basket?success";
    }

    @GetMapping("/payment")
    public String getPaymentPage() {
        return "credit_card";
    }

    @PostMapping("/payment/pay")
    public String setNewBalance(@AuthenticationPrincipal User user, @RequestParam(name = "amount") BigDecimal amount) {
        userService.topUpAccount(user, amount);
        return "redirect:/account";
    }

    @GetMapping("/users/{id}/account_history")
    public String getUserReceiptsHistory(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("id", id);
        return "account_history";
    }
}
