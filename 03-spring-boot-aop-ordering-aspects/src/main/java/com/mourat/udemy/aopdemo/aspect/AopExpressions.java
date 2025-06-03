package com.mourat.udemy.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AopExpressions {

    // Pointcut expressions for aspects
    // Any method in the package dao
    @Pointcut("execution(* com.mourat.udemy.aopdemo.dao.*.*(..))")
    public void daoPackage(){
    }

    // Getters in the package dao
    @Pointcut("execution(* com.mourat.udemy.aopdemo.dao.*.get*(..))")
    public void daoGetters(){
    }

    // Setters in the package dao
    @Pointcut("execution(* com.mourat.udemy.aopdemo.dao.*.set*(..))")
    public void daoSetters(){
    }

    // All methods except getters and setters in the package dao
    @Pointcut("daoPackage() && !(daoGetters() || daoSetters())")
    public void daoNoGetSet(){
    }
}
