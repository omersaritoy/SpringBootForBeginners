package com.example.aopdemo.dao;


import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    @Override
    public void addAccount() {
        System.out.println(getClass()+": DOING MY WORK: ADDING AN ACCOUNT");
    }
}
