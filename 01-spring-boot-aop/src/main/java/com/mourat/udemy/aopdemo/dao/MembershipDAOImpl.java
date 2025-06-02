package com.mourat.udemy.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public void addSillyMember() {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A SILLY MEMBER ACCOUNT");
    }
}
