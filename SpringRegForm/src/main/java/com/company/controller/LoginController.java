package com.company.controller;

import com.company.dto.UserDTO;
import com.company.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

   // @ResponseStatus(HttpStatus.CREATED)
   // @RequestMapping(value = "registration", method = RequestMethod.POST)
    @PostMapping("/registration")
    public String registrUser(UserDTO userDTO, Model model) {
        userService.setUserDTO(userDTO);
        if (userService.saveNewUser()) {
            model.addAttribute("success", true);
            model.addAttribute("exist", false);
        } else {
            model.addAttribute("success", false);
            model.addAttribute("exist", true);
        }
        return "registration";
    }

    //@RequestMapping(value = "registration", method = RequestMethod.GET)
    @GetMapping("/registration")
    public String userPage(Model model) {
        model.addAttribute("exist", false);
        model.addAttribute("success", false);
        return "registration";
    }

    @RequestMapping("/login")
    public String getLoginPage(@RequestParam(name = "error", required = false) String error,
                               @RequestParam(name = "logout", required = false) String logout,
                               Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
    }
}
