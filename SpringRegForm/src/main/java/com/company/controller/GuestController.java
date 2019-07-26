package com.company.controller;

import com.company.dto.ApplicationDTO;
import com.company.service.ApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GuestController {
    private final ApplicationService applicationService;

    public GuestController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/")
    public String homePage() {
        return "home_page";
    }

    @GetMapping("/calculate")
    public String getMap() {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String test(ApplicationDTO applicationDTO) {
        applicationService.addApplication(applicationDTO);
        return "redirect:/calculate/result";
    }

    @GetMapping("/calculate/result")
    public String getResult(Model model) {
        model.addAttribute("result", applicationService.getApplicationCost());
        return "calc_result";
    }
}
