package com.mourat.udemy.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(5)
@Component
public class MyCloudLogAsyncAspect {

    // Advice to log to cloud in async fashion
    // Before execution
    // For any class except getters and setters
    @Before("com.mourat.udemy.aopdemo.aspect.AopExpressions.daoNoGetSet()")
    public void logToCloudAsync(){
        System.out.println("\n=====>>> Logging to Cloud in async fashion");
    }
}
