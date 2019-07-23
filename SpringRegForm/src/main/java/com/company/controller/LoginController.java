package com.company.controller;

import com.company.dto.UserDTO;
import com.company.dto.UsersDTO;
import com.company.entity.Receipt;
import com.company.entity.Role;
import com.company.repository.ReceiptRepository;
import com.company.service.ApplicationService;
import com.company.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Slf4j
@RestController
@RequestMapping(value = "/")
public class LoginController {

    private final UserService userService;
    private final ApplicationService applicationService;

    private final ReceiptRepository receiptRepository;

    public LoginController(UserService userService, ApplicationService applicationService, ReceiptRepository receiptRepository) {
        this.applicationService = applicationService;
        this.userService = userService;
        this.receiptRepository = receiptRepository;
    }

    @RequestMapping(value = "get_users", method = RequestMethod.GET)
    public UsersDTO userList() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "userDTO", method = RequestMethod.GET)
    public UserDTO user() {
        return userService.getUserDTO();
    }

    @GetMapping("/main/receipts")
    public Receipt getReceipts() {
        receiptRepository.save(applicationService.createReceipt(userService.getCurrentUser()));
        return applicationService.createReceipt(userService.getCurrentUser());
    }

    @GetMapping("/main/rip")
    public Set<Receipt> getRec() {
        return userService.getCurrentUser().getReceipts();
    }
}
