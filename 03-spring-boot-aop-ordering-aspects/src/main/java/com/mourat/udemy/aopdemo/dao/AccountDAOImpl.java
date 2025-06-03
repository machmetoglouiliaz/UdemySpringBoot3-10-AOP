package com.mourat.udemy.aopdemo.dao;

import com.mourat.udemy.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    // Test fields for getters and setters
    private String name;
    private String email;


    @Override
    public void addAccount(Account account, boolean vipFlag) {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(this.getClass() + ": doWork()");
        return false;
    }

    public String getName() {
        System.out.println(this.getClass() + ": getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(this.getClass() + ": setName()");
        this.name = name;
    }

    public String getEmail() {
        System.out.println(this.getClass() + ": getEmail()");
        return email;
    }

    public void setEmail(String email) {
        System.out.println(this.getClass() + ": setEmail()");
        this.email = email;
    }
}
