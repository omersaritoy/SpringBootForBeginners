package com.example.aopdemo.aspect;


import com.example.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

    @Before("com.example.aopdemo.aspect.PointcutsAspect.forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(JoinPoint joinPoint) {
        System.out.println("\n-------> Performing API Analytics");


        //display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method Signature: " + methodSignature);
        //display method arguments

        //get args
        Object[] args = joinPoint.getArgs();

        //loop throw args
        for(Object arg : args){
            System.out.println(arg);

            if(arg instanceof Account){
                //downcast and print Account specific stuff
                Account account = (Account)arg;
                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());
            }
        }

    }


}
