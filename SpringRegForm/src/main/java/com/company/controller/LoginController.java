package com.company.controller;

import com.company.dto.UserDTO;
import com.company.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

   // @ResponseStatus(HttpStatus.CREATED)
   // @RequestMapping(value = "registration", method = RequestMethod.POST)
    @PostMapping("/registration")
    public String registrUser(@Valid UserDTO userDTO, BindingResult bindingResult, Model model) {
        userService.setUserDTO(userDTO);
        if (bindingResult.hasErrors()){
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("userDTO",userDTO);
        } else {
            userService.saveNewUser();// return "redirect:/registration?success";
// return "redirect:/registration?exist";
        }
        return "redirect:/registration";
    }


    //@RequestMapping(value = "registration", method = RequestMethod.GET)
    @GetMapping("/registration")
    public String userPage(@RequestParam(name = "exist", required = false) String exist,
                           @RequestParam(name = "success", required = false) String success,
                           Model model) {
        model.addAttribute("exist", exist != null);
        model.addAttribute("success", success != null);
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
