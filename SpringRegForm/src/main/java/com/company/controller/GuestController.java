package com.company.controller;

import com.company.dto.AppWeightAddressDTO;
import com.company.service.ApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

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
    public String test(@Valid AppWeightAddressDTO applicationDTO,
                       BindingResult bindingResult,
                       Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("applicationDTO", applicationDTO);
            return "calculator";
        } else {
            applicationService.addApplication(applicationDTO);
        }
        return "redirect:/calculate/result";
    }

    @GetMapping("/calculate/result")
    public String getResult(Model model) {
        model.addAttribute("result", applicationService.getApplicationCost());
        return "calc_result";
    }
}
