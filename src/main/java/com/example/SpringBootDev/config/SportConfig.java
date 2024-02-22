package com.example.SpringBootDev.config;

import com.example.SpringBootDev.common.Coach;
import com.example.SpringBootDev.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
