package com.company.controller;

import com.company.entity.Role;
import com.company.entity.User;
import com.company.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.spi.ResourceBundleProvider;

@Slf4j
@Controller
public class PagesController {

    private final UserService userService;

    public PagesController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("id",userService.getCurrentUser().getId());
        model.addAttribute("email",userService.getCurrentUser().getEmail());
        model.addAttribute("role",userService.getCurrentUser().getAuthorities());
        if ( userService.getCurrentUser().getAuthorities().contains(Role.ADMIN)){
            model.addAttribute("admin",true);
        }else {
            model.addAttribute("admin",false);
        }
        return "main";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public String registrUser(User user,Model model) {
        if(userService.saveNewUser(user)) {
            model.addAttribute("success",true);
            model.addAttribute("exist",false);
        } else {
            model.addAttribute("success",false);
            model.addAttribute("exist",true);
        }
        return "registration";
    }

    @RequestMapping(value = "registration",method = RequestMethod.GET)
    public String userPage(Model model) {
        model.addAttribute("exist",false);
        model.addAttribute("success",false);
        return "registration";
    }

    @RequestMapping("/all_users")
    public String showAllUsers() {
        return "users";
    }

    @RequestMapping("/login")
    public String getLoginPage(@RequestParam(name = "error", required = false) String error,
                               @RequestParam(name = "logout",required = false) String logout,
                               Model model) {
        model.addAttribute("error",error != null);
        model.addAttribute("logout",logout != null);
        return "login";
    }

    @GetMapping("/international")
    public String getInternationalPage(Model model) {
        model.addAttribute("greeting",ResourceBundle.getBundle("messages", new Locale("ua", "UA")).getString("greeting"));
        return "international";
    }
}
