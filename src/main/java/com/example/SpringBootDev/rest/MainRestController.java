package com.example.SpringBootDev.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class MainRestController {
    // Custom properties injection
    @Value("${properties.test}")
    private String testProperty;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/customproperties")
    public String getTestProperty() {
        return String.format("%s - %s", this.testProperty, this.teamName);
    }

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        Random random = new Random();
        int newInt = random.nextInt(2);
        if (newInt == 1) {
            return "Today is your lucky day";
        }
        return "Today is not lucky";
    }
}
