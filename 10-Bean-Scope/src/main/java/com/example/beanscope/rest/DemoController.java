package com.example.beanscope.rest;





import com.example.beanscope.common.Coach;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final Coach coach;
    private final Coach anotherCoach;


    public DemoController(@Qualifier("baseballCoach") Coach coach,@Qualifier("cricketCoach") Coach anotherCoach) {
        this.anotherCoach = anotherCoach;
        System.out.println("In Constructor:" +getClass().getSimpleName());
        this.coach = coach;
    }


    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }

    @GetMapping
    public String check(){
        //prototype --> false
        //singleton -->true
        return "Compare beans:myCoach==anotherCoach"+(coach==anotherCoach);
    }
}
