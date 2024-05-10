package com.example.SpringBootDev.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class TestController {
    @GetMapping("/hello")
    public String returnHello(Model model) {
        model.addAttribute("currentTime", LocalDateTime.now());
        return "helloworld";
    }
}
