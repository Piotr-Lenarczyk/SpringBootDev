package com.example.SpringBootDev.rest;

import com.example.SpringBootDev.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {
    private final Coach coach;

    @Autowired
    public CoachController(@Qualifier("cricketCoach") Coach coach) {
        System.out.println("Constructing " + getClass().getSimpleName());
        this.coach = coach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return this.coach.getDailyWorkout();
    }
}
