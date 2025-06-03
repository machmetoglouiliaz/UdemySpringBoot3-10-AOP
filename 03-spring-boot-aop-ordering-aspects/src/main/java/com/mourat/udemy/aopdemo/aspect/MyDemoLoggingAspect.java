package com.mourat.udemy.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Order(10)
@Component
public class MyDemoLoggingAspect {

    // Advice to do some fancy logging stuff
    // Before execution
    // For any method except getters and setters
    @Before("com.mourat.udemy.aopdemo.aspect.AopExpressions.daoNoGetSet()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Executing @Before advice for logging");
    }

}