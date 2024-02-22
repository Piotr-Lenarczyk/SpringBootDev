package com.example.SpringBootDev.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Run for 5k steps.";
    }
}
