package com.mourat.udemy.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // @Before advice for addAccount()
    @Before("execution(public void add*())")
    public void beforeAddAccount(){
        System.out.println("\n=====>>> Executing @Before advice on add*()");
    }
}
