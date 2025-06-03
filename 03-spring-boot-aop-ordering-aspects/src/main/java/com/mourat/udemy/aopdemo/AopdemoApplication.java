package com.mourat.udemy.aopdemo;

import com.mourat.udemy.aopdemo.dao.AccountDAO;
import com.mourat.udemy.aopdemo.dao.MembershipDAO;
import com.mourat.udemy.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO adao, MembershipDAO mdao, TrafficFortuneService trafficFortuneService){
		return runner -> {

			// Test bench for @Before advice and expressions
			// @Before advice with pointcut every method in dao package except getters and setters
			//demoBeforeAdvice(adao, mdao);

			// Test bench for @AfterReturning advice
			// @AfterReturning advice with pointcut findAccounts(..) in AccountDAO in dao package
			//demoAfterReturningAdvice(adao);

			// Test bench for @AfterThrowing advice
			// @AfterThrowing advice with pointcut findAccounts(..) in AccountDAO in dao package
			//demoAfterThrowingAdvice(adao);

			// Test bench for @After advice
			// @After advice with pointcut findAccounts(..) in AccountDAO in dao package
			//demoAfterAdvice(adao);

			// Test bench for @Around advice
			// @Around advice with pointcut getFortune(..) in TrafficFortuneService in service package
			demoAroundAdvice(trafficFortuneService);

		};
	}

	private void demoAroundAdvice(TrafficFortuneService trafficFortuneService) {

		// Get a fortune from service and display it
		System.out.println("\n\nMain Program: demoAroundAdvice");
        try {
			System.out.println("\n\nMain Program: Calling getFortune with false value");
            System.out.println(trafficFortuneService.getFortune());

			System.out.println("\n\nMain Program: Calling getFortune with false value");
			System.out.println(trafficFortuneService.getFortune(true));
        } catch (Exception e) {
			System.out.println(e);
        }
    }

	private void demoAfterAdvice(AccountDAO adao) {

		// Get the accounts from dao
		List<Account> accounts = null;
		boolean tripWire;

		// Throws an exception intentionally if the tripWire is true
		try {
			System.out.println("\n\nMain Program: Calling findAccount with false value");
			tripWire = false;
			accounts = adao.findAccounts(tripWire);

			System.out.println("\n\nMain Program: Calling findAccount with true value");
			tripWire = true;
			accounts = adao.findAccounts(tripWire);
		} catch(Exception e){
			System.out.println("Main Program: Caught an exception: " + e);
		}

		// Display them for testing reasons
		System.out.println("\n\nMain Program: demoAfterAdvice");
		System.out.println("-".repeat(40));
		System.out.println(accounts);
	}

	private void demoAfterThrowingAdvice(AccountDAO adao) {
		// Get the accounts from dao
		List<Account> accounts = null;
		boolean tripWire = true;

		// Throws an exception intentionally if the tripWire is true
		try {
			accounts = adao.findAccounts(tripWire);
		} catch(Exception e){
			System.out.println("Main Program: Caught an exception: " + e);
		}

		// Display them for testing reasons
		System.out.println("\n\nMain Program: demoAfterAdvice");
		System.out.println("-".repeat(40));
		System.out.println(accounts);
	}

	private void demoAfterReturningAdvice(AccountDAO adao) {

		// Get the accounts from dao
		List<Account> accounts = adao.findAccounts();

		// Display them for testing reasons
		System.out.println("\n\nMain Program: demoAfterAdvice");
		System.out.println("-".repeat(40));
		System.out.println(accounts);
	}

	private void demoBeforeAdvice(AccountDAO adao, MembershipDAO mdao) {

		// DAOs are injected to command liner automatically (They are beans)
		// Call some functions, getters and setters of daos to test aspects
		adao.addAccount( new Account("Mourat", "Over 9000!"), true);
		adao.doWork();

		adao.setName("test");
		adao.setEmail("gmail");

		adao.getEmail();
		adao.getName();

		mdao.addSillyMember();
		mdao.goToSleep();
	}
}
