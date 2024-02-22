package com.example.SpringBootDev.common;

public interface Coach {
    String getDailyWorkout();

    // Initialization
    void startUp();

    // Destruction
    void cleanUp();
}
