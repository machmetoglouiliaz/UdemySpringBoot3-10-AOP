package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void controllerPackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void daoPackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void servicePackage(){}

    @Pointcut("controllerPackage() || daoPackage() || servicePackage()")
    private void loggerPackages(){}

    @Before("loggerPackages()")
    public void beforeLogger(JoinPoint joinPoint){

        // Display the method we are advising
        myLogger.info("====>>> In @Before: Method called: " + joinPoint.getSignature().toShortString());

        // Display the arguments
        for(Object o : joinPoint.getArgs()){
            System.out.println("====>>> Argument: " + o);
        }
    }

    @AfterReturning(
            pointcut = "loggerPackages()",
            returning = "result")
    public void afterReturningLogger(JoinPoint joinPoint, Object result){

        // Display the method we are advising
        myLogger.info("====>>> In @AfterReturning: Method called: " + joinPoint.getSignature().toShortString());

        // Display data returned
        myLogger.info("====>>> In @AfterReturning: Result: " + result);
    }
}
