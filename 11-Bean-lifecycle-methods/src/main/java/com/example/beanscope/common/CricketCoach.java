package com.example.beanscope.common;




import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In Constructor:" +getClass().getSimpleName());
    }

    //define our init method
    //it works when we run project
    @PostConstruct
    public void doMyStartupStaff(){
        System.out.println("In doMyStartupStaff():"+getClass().getSimpleName());
    }


    //define our destroy method
    //when stop the project it will run
    @PreDestroy
    public void doMyCleanupStaff(){
        System.out.println("In doMyCleanupStaff():"+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
