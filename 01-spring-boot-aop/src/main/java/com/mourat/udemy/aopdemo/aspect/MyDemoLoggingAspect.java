package com.mourat.udemy.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // @Before advice for methods start with add() and has any return type and with any parameter
    @Before("execution(* com.mourat.udemy.aopdemo.dao.*.*(..))")
    public void beforeAddAccount(){
        System.out.println("\n=====>>> Executing @Before advice on any method");
    }
}
