package com.mourat.udemy.aopdemo.aspect;

import com.mourat.udemy.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
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
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        System.out.println("\n=====>>> Executing @Before advice for logging");

        // Display the method signature
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        System.out.println("Method: " + signature);

        // Display the method arguments
        Object[] args = joinPoint.getArgs();

        for(Object arg : args){
            System.out.println(arg);
            // Downcast and print Account specific stuff
            if(arg instanceof Account){
                Account acc = (Account) arg;

                System.out.println("Account name: " + acc.getName());
                System.out.println("Account level: " + acc.getLevel());
            }
        }
    }

}