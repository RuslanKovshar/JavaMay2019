package com.company.controller;

import com.company.dto.LoadDTO;
import com.company.dto.UserDTO;
import com.company.entity.Load;
import com.company.entity.Role;
import com.company.service.LoadService;
import com.company.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class PagesController {

    private final UserService userService;
    private final LoadService loadService;

    public PagesController(UserService userService, LoadService loadService) {
        this.loadService = loadService;
        this.userService = userService;
    }

    @RequestMapping("/main")
    public String mainPage(Model model) {
        model.addAttribute("user",userService.getCurrentUser());
        if ( userService.getCurrentUser().getAuthorities().contains(Role.ADMIN)){
            model.addAttribute("admin",true);
        }else {
            model.addAttribute("admin",false);
        }
        return "main";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public String registrUser(UserDTO userDTO, Model model) {
        userService.setUserDTO(userDTO);
        if(userService.saveNewUser()) {
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
    @PreAuthorize("hasAuthority('ADMIN')")
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

    @GetMapping("/calculate")
    public String getMap(Model model) {
        model.addAttribute("price",false);
        return "calculator";
    }

    @GetMapping("/calculate/result")
    public String getResult(Model model) {
        model.addAttribute("load",loadService.getLoad());
        return "calc_result";
    }

    @PostMapping("/calculate")
    public String test(LoadDTO loadDTO) {
        loadService.createLoad(loadDTO);
        return "redirect:/calculate/result";
    }

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/user_account")
    public String getUserAccount() {
        return "user_account";
    }

    @PostMapping("/user_account")
    public String setUserAccount(LoadDTO loadDTO) {
        log.info("{}",loadDTO);
        return "user_account";
    }
}
