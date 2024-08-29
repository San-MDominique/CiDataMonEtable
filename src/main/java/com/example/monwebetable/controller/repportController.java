package com.example.monwebetable.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reports")

public class repportController {
    @GetMapping
    public String showRapport() {
        return "reports/forms"; //
    }


}
