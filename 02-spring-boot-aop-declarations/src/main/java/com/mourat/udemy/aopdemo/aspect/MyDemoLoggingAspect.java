package com.mourat.udemy.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // @Before advice for methods start with add() and has any return type and with any parameter
    @Pointcut("execution(* com.mourat.udemy.aopdemo.dao.*.*(..))")
    public void daoPackagePointcut(){

    }

    @Before("daoPackagePointcut()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Executing @Before advice on any method");
    }

    @Before("daoPackagePointcut()")
    public void performAPIAnalytics(){
        System.out.println("\n====>>> Performing API analytics");
    }
}
