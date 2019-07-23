package com.company.controller;

import com.company.dto.UserDTO;
import com.company.dto.UsersDTO;
import com.company.entity.Receipt;
import com.company.service.ApplicationService;
import com.company.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/")
public class LoginController {

    private final UserService userService;
    private final ApplicationService applicationService;

    public LoginController(UserService userService, ApplicationService applicationService) {
        this.applicationService = applicationService;
        this.userService = userService;
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
        return applicationService.createReceipt();
    }
}
