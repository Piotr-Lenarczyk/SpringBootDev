package com.example.SpringBootDev.rest;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class TestController {
    @GetMapping("/hello")
    public String returnHello(Model model) {
        model.addAttribute("currentTime", LocalDateTime.now());
        return "helloworld";
    }

    @GetMapping("/displayForm")
    public String displayForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("/processFormV2")
    public String capitalize(HttpServletRequest request, Model model) {
        String message = request.getParameter("studentName");
        message = message.toUpperCase();
        model.addAttribute("message", message);
        model.addAttribute("currentTime", LocalDateTime.now());
        return "helloworld";
    }

    @PostMapping("/processFormV3")
    public String autoCapitalize(@RequestParam("studentName") String studentName, Model model) {
        studentName = studentName.concat(" automatically").toUpperCase();
        model.addAttribute("message", studentName);
        model.addAttribute("currentTime", LocalDateTime.now());
        return "helloworld";
    }
}
