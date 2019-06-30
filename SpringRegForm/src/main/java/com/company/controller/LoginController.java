package com.company.controller;

import com.company.entity.User;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/")
public class LoginController {

    private final UserService userService;

    @Autowired
    LoginController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public void registrUser(User user) {
        userService.saveNewUser(user);
    }

    @RequestMapping(value = "get_users", method = RequestMethod.GET)
    public List<User> userList() {
        return userService.getAllUsers();
    }
}
