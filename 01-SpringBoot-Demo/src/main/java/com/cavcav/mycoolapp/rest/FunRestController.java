package com.cavcav.mycoolapp.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class FunRestController {


    //expose "/" that return "Hello World"
    @GetMapping
    public String hello(){
        return "Hello World";
    }

    //expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String workout(){
        return "Run a hard 5k";
    }

    //expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String fortune(){
        return "Today is your lucky day.";
    }
}
