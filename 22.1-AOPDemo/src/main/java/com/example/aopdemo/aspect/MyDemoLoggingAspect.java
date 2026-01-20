package com.example.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //this is where we add all of our related advices for logging

    //let's start with a @before advice

    //@Before("execution(public void addAccount())")
    //@Before("execution(public void add*())")
    //@Before("execution(void add*())")
    //@Before("execution(* add*(com.example.aopdemo.Account))")
    //@Before("execution(* add*(com.example.aopdemo.Account,..))")
    //@Before("execution(* com.example.aopdemo..add*(..))")
    @Before("execution(* com.example.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n==============> Executing @Before advice on method");
    }

}
