package com.mourat.udemy.aopdemo.aspect;

import com.mourat.udemy.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


@Aspect
@Order(10)
@Component
public class MyDemoLoggingAspect {

    // Advice to do some stuff
    // Before and after execution
    // For the method getFortune in class TrafficFortuneService
    @Around("execution(* com.mourat.udemy.aopdemo.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortuneAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        // Print the method we are advising on
        System.out.println("\n====>>> Executing @Around on method: " + proceedingJoinPoint.getSignature().toShortString());

        // Get the timestamp before executing the adviced method
        long startTime = System.currentTimeMillis();

        Object result = null;

        // Execute the method
        try {
            result = proceedingJoinPoint.proceed();
        }catch (Exception e) {
            System.out.println("@Arround advice: We have a problem " + e);

            result = "This is not an exception: Everything is handled by @Around advice! Don't worry, continue to do stuff! (Uncomment throw line if you want it rethrown)";

            // In case you want to rethrow the exception
            //throw e;
        }

        // Get the timestamp after execution
        long endTime = System.currentTimeMillis();

        // Display how long the method execution took
        System.out.println("====>>> Method took " + (endTime - startTime)/1000.0 + " seconds to return");

        // A new line for cosmetic only
        System.out.println();

        return result;
    }

    // Advice to do some stuff
    // After the method returns in any case
    // For the method findAccount in class AccountDAO
    @After("execution(* com.mourat.udemy.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){

        // Print the method we are advising on
        System.out.println("\n====>>> Executing @After on method: " + joinPoint.getSignature().toShortString());

        // A new line for cosmetic only
        System.out.println();
    }

    // Advice to do some catch stuff
    // After throwing an exception
    // For the method findAccount in class AccountDAO
    @AfterThrowing(
            pointcut = "execution(* com.mourat.udemy.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exc"
    )
    public void AfterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc){

        // Print the method we are advising on
        System.out.println("\n====>>> Executing @AfterThrowing on method: " + joinPoint.getSignature().toShortString());

        // Print the exception
        System.out.println("====>>> The exception is: " + exc);

        // A new line for cosmetic only
        System.out.println();
    }

    // Advice to do some fancy logging stuff
    // After returning normally
    // For the method findAccount in class AccountDAO
    @AfterReturning(
            pointcut = "execution(* com.mourat.udemy.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void AfterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){

        // Print the method we are advising on
        System.out.println("\n====>>> Executing @AfterReturning on method: " + joinPoint.getSignature().toShortString());

        // Print the result of the method call
        System.out.println("====>>> Result: " + result);

        // Post-process data
        // Convert the account names to upper case
        convertAccountNamesToUpperCase(result);

        // A new line for cosmetic only
        System.out.println();
    }

    // Converts the account names to upper case
    private void convertAccountNamesToUpperCase(List<Account> accounts) {

        // Loop for each account in the list
        for(Account a : accounts){
            // Set the name to the upper case version
            a.setName(a.getName().toUpperCase());
        }
    }

    // Advice to do some fancy logging stuff
    // Before execution
    // For any method except getters and setters
    @Before("com.mourat.udemy.aopdemo.aspect.AopExpressions.daoNoGetSet()")
    public void beforeAddAccountsAdvice(JoinPoint joinPoint){
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

        // A new line for cosmetic only
        System.out.println();
    }

}