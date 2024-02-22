package com.example.SpringBootDev.common;

public class SwimCoach implements Coach {
    public SwimCoach() {
        System.out.println("Constructing " + getClass().getSimpleName());
    }

    @Override
    public void startUp() {
        System.out.println("Initializing " + getClass().getSimpleName());
    }

    @Override
    public void cleanUp() {
        System.out.println("Cleaning up " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters.";
    }
}
