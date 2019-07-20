package com.company.controller;

import com.company.dto.LoadDTO;
import com.company.dto.UserDTO;
import com.company.entity.Load;
import com.company.entity.Role;
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
    private final Load load;

    public PagesController(UserService userService, Load load) {
        this.load = load;
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

    @GetMapping("/map")
    public String getMap(Model model) {
        model.addAttribute("price",false);
        return "calculator";
    }

    @GetMapping("/map/result")
    public String getResult(Model model) {
        model.addAttribute("load",load);
        return "calc_result";
    }

    @PostMapping("/map")
    public String test(LoadDTO loadDTO) {
        load.setStartPoint(loadDTO.getStartPoint());
        load.setEndPoint(loadDTO.getEndPoint());
        load.setWeight(loadDTO.getWeight());
        load.calculateShippingCost();
        log.info("{}",load);
        return "redirect:/map/result";
    }


    /*@PostMapping("/weight")
    public String setWeight(@RequestParam(name = "weight") Double weight){
        load.setWeight(weight);
        log.info("{}",load.calculateShippingCost());
       // model.addAttribute("price", weight);
        return "redirect:/map?price=" + load.calculateShippingCost();
    }*/
}
