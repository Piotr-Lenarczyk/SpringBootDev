package com.example.SpringBootDev.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {
    @Value("${properties.test}")
    private String test;

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }
}
