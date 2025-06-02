package com.mourat.udemy.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // Pointcut for any method in package dao
    @Pointcut("execution(* com.mourat.udemy.aopdemo.dao.*.*(..))")
    private void daoPackage(){
    }

    @Pointcut("execution(* com.mourat.udemy.aopdemo.dao.*.get*(..))")
    private void daoGetters(){
    }

    @Pointcut("execution(* com.mourat.udemy.aopdemo.dao.*.set*(..))")
    private void daoSetters(){
    }

    @Pointcut("daoPackage() && !(daoGetters() || daoSetters())")
    private void daoNoGetSet(){
    }


    @Before("daoNoGetSet()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Executing @Before advice on any method");
    }

    @Before("daoPackage()")
    public void performAPIAnalytics(){
        System.out.println("\n====>>> Performing API analytics");
    }
}
