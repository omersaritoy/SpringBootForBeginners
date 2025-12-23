package com.cavcav.mycoolapp.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class FunRestController {

    @GetMapping
    public String hello(){
        return "Hello World";
    }

}
