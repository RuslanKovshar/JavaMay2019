package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {

    @RequestMapping("/")
    public String mainPage() {
        return "index.html";
    }

    @RequestMapping("/new_user")
    public String userPage() {
        return "registration.html";
    }

    @RequestMapping("/all_users")
    public String showAllUsers() {
        return "users.html";
    }
}
