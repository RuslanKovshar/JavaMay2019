package com.company.controller;

import com.company.dto.*;
import com.company.entity.*;
import com.company.exceptions.TransactionException;
import com.company.service.ApplicationService;
import com.company.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Slf4j
@Controller
@RequestMapping("/account")
public class PagesController {

    private final UserService userService;
    private final ApplicationService applicationService;

    public PagesController(UserService userService, ApplicationService applicationService) {
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
    public String setApplication(@AuthenticationPrincipal User user, Application application, HttpSession session) {
        log.info("{}", application);
        applicationService.setApplication(application);
        applicationService.addReceiptToSession(applicationService.createReceipt(user), session);
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
    public String setNewBalance(@RequestParam(name = "amount") BigDecimal amount) {
        userService.topUpAccount(userService.getCurrentUser(), amount);
        return "redirect:/account";
    }

    @GetMapping("/users/{id}/account_history")
    public String getUserReceiptsHistory(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("id", id);
        return "account_history";
    }
}
