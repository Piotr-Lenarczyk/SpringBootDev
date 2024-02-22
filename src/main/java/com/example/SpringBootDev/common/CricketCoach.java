package com.example.SpringBootDev.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("Constructing " + getClass().getSimpleName());
    }

    @Override
    @PostConstruct
    public void startUp() {
        System.out.println("Initializing " + getClass().getSimpleName());
    }

    @Override
    @PreDestroy
    public void cleanUp() {
        System.out.println("Cleaning up " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 10 minutes!";
    }
}
