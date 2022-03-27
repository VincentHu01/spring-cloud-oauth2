package com.ai.uaa.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/home")
    public String homePage() {
        return "welcome to home page!";
    }
}
