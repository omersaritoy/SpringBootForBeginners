package com.example.springcoredemo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
