package com.mourat.udemy.aopdemo.dao;

import com.mourat.udemy.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account account, boolean vipFlag);

    boolean doWork();

    String getName();

    void setName(String name);

    String getEmail();

    void setEmail(String email);
}
