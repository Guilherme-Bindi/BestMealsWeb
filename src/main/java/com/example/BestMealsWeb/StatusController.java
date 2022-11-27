package com.example.BestMealsWeb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class StatusController {

    @GetMapping
    public String getIndex(Model model){
        return "index";
    }

    @GetMapping("status")
    public String get(Model model){
        model.addAttribute("status","Online");
        return "status";
    }

}
