package com.example.springcorequalifiers.rest;



import com.example.springcorequalifiers.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final Coach coach;
    //if u don't use @Qualifier annotation application can't run because app don't know which bean will work
    public DemoController(@Qualifier("baseballCoach") Coach coach) {
        this.coach = coach;
    }


    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }
}
