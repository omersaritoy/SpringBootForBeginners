package com.example.aopdemo;

import com.example.aopdemo.dao.AccountDAO;
import com.example.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AOPDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AOPDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        return runner -> {
            // demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
            // demoTheAfterReturningAdvice(theAccountDAO);
            demoTheAfterThrowingAdvice(theAccountDAO);
        };
    }

    private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {

        // call method to find the accounts
        List<Account> accounts = null;

        try {
            //add a boolean flag to simulate exception
            boolean tripWire=true;
            accounts = theAccountDAO.findAccounts(tripWire);
        } catch (Exception ex) {
            System.out.println("\n\nMain Program:... caught exception:"+ex.getMessage());
        }

        //display the accounts
        System.out.println("\n\nMain Program:demoTheAfterThrowingAdvice");
        System.out.println("--------");
        System.out.println(accounts);
        System.out.println("\n");

    }

    private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
        // call method to find the accounts
        List<Account> accounts = theAccountDAO.findAccounts();

        //display the accounts
        System.out.println("\n\nMain Program:demoTheAfterReturningAdvice");
        System.out.println("--------");
        System.out.println(accounts);
        System.out.println("\n");

    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        //Call the business method
        Account account = new Account();
        account.setName("John");
        account.setLevel("Platinum");
        theAccountDAO.addAccount(account, true);
        theAccountDAO.doWork();

        //call the accountdao getter/setter methods
        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");

        String name = theAccountDAO.getName();
        String serviceCode = theAccountDAO.getServiceCode();

        //call the membership business method
        theMembershipDAO.addAccount();
        theMembershipDAO.goToSleep();


    }
}
