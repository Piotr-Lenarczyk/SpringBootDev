package com.example.SpringBootDev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "plain-login";
    }

    @GetMapping("/access-denied")
    public String denyAccess() {
        return "access-denied";
    }
}
