package com.example.lazyinitialization.rest;




import com.example.lazyinitialization.common.Coach;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final Coach coach;
    //if u don't use @Qualifier annotation application can't run because app don't know which bean will work
    public DemoController(@Qualifier("baseballCoach") Coach coach) {
        System.out.println("In Constructor:" +getClass().getSimpleName());
        this.coach = coach;
    }


    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }
}
