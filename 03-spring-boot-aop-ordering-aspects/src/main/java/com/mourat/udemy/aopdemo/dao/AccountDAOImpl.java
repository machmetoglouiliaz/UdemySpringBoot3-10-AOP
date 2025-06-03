package com.mourat.udemy.aopdemo.dao;

import com.mourat.udemy.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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

    // Creates a dummy list of accounts and returns it (for testing purposes of @After advices)
    @Override
    public List<Account> findAccounts() {

        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        // If tripWire is true throw an exception (to test @AfterThrowing advice)
        if(tripWire) throw new RuntimeException("No soup for you!");

        // Create a new empty list
        List<Account> myAccounts = new ArrayList<>();

        // Add some dummy accounts in
        myAccounts.add(new Account("Mourat", "Over 9000"));
        myAccounts.add(new Account("Kostas", "Worth everything!"));

        // Return the list
        return myAccounts;
    }
}
