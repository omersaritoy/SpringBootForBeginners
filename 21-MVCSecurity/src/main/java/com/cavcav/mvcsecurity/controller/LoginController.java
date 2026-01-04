package com.cavcav.mvcsecurity.controller;


import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


    @GetMapping("/loginPage")
    public String loginPage() {
        return "loginPage";
    }


}
