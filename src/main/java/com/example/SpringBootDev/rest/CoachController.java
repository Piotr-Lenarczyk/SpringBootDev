package com.example.SpringBootDev.rest;

import com.example.SpringBootDev.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {
    private final Coach coach;
    private final Coach anotherCoach;

    @Autowired
    public CoachController(@Qualifier("cricketCoach") Coach coach, @Qualifier("cricketCoach") Coach anotherCoach) {
        System.out.println("Constructing " + getClass().getSimpleName());
        this.coach = coach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return this.coach.getDailyWorkout();
    }

    @GetMapping("/checkscope")
    public String checkScope() {
        return "Comparing beans: myCoach == anotherCoach, " + (this.coach == this.anotherCoach);
    }
}
