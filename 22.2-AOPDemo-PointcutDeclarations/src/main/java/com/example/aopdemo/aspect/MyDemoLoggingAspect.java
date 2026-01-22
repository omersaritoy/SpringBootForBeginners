package com.example.aopdemo.aspect;


import com.example.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {


    // add a new advice for @AfterReturning on the findAccounts method

    @AfterReturning(pointcut = "execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        //print out which method we are advising on
        String methodName = joinPoint.getSignature().toString();
        System.out.println("\n--------->Executing @AfterReturning on method: " + methodName);
        System.out.println("------------");

        //print out the results of the method call
        System.out.println("\n----------->Result is: "+result);
    }


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
        for (Object arg : args) {
            System.out.println(arg);

            if (arg instanceof Account) {
                //downcast and print Account specific stuff
                Account account = (Account) arg;
                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());
            }
        }

    }


}
