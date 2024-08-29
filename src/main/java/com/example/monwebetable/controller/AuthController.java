package com.example.monwebetable.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AuthController {

    // Affiche la page de connexion
    @GetMapping
    public String Auth() {
        return "auth/login";
    }
}
