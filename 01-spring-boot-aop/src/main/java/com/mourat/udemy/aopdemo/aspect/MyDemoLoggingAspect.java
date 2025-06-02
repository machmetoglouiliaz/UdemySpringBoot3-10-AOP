package com.mourat.udemy.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // @Before advice for methods start with add() and has any return type
    @Before("execution(* add*())")
    public void beforeAddAccount(){
        System.out.println("\n=====>>> Executing @Before advice on add*()");
    }
}
