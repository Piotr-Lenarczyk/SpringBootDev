package com.example.SpringBootDev.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {
    public TrackCoach() {
        System.out.println("Constructing " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run for 5k steps.";
    }
}
