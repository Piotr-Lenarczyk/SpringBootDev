package com.example.SpringBootDev.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    public TennisCoach() {
        System.out.println("Constructing " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice you backhand volley.";
    }
}
