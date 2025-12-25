package com.example.javaconfigbean.config;


import com.example.javaconfigbean.common.Coach;
import com.example.javaconfigbean.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }

}
