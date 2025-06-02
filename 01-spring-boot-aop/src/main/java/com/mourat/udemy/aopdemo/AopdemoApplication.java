package com.mourat.udemy.aopdemo;

import com.mourat.udemy.aopdemo.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO dao){
		return runner -> {
			demoTheBeforeAdvice(dao);

		};
	}

	private void demoTheBeforeAdvice(AccountDAO dao) {

		// Call addAccount from DAO... DAO is injected to command liner automatically (It's a bean)
		dao.addAccount();

		// Let's call it again to be sure!
		System.out.println("\nLet's call it again!\n");

		// Second call of addAccount() to be sure @Before is working correctly
		dao.addAccount();
	}
}
