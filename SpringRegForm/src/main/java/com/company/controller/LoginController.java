package com.company.controller;

import com.company.dto.UserDTO;
import com.company.dto.UsersDTO;
import com.company.exceptions.IncorrectDataException;
import com.company.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/")
public class LoginController {

    private final UserService userService;

    @Autowired
    LoginController(UserService userService) {
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
}
