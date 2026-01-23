package com.example.aopdemo.aspect;


import com.example.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {


    @AfterThrowing(
            pointcut = "execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint,Throwable theExc) {


        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n=====>>> The exception is: " + theExc);
    }


    // add a new advice for @AfterReturning on the findAccounts method

    @AfterReturning(pointcut = "execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        //print out which method we are advising on
        String methodName = joinPoint.getSignature().toString();
        System.out.println("\n--------->Executing @AfterReturning on method: " + methodName);
        System.out.println("------------");

        //print out the results of the method call
        System.out.println("\n----------->Result is: " + result);


        //let's post-process the data... let's modify it
        //convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n\n\n--------->Result Modify is :" + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        //loop through accounts
        result.forEach(x -> x.setName(x.getName().toUpperCase()));

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
