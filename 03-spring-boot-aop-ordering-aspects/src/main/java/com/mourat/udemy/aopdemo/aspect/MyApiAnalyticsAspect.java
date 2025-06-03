package com.mourat.udemy.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(15)
@Component
public class MyApiAnalyticsAspect {

    // Advice to do API analytics
    // Before execution
    // For any class except getters and setters
    @Before("com.mourat.udemy.aopdemo.aspect.AopExpressions.daoNoGetSet()")
    public void performAPIAnalytics(){
        System.out.println("\n====>>> Performing API analytics");
    }
}
