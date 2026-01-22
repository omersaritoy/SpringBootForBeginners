package com.example.aopdemo.dao;

import com.example.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount(Account account, boolean vipFlag);

    boolean doWork();

    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);
    
    // add a new method:findAccounts()
    List<Account> findAccounts();

}
