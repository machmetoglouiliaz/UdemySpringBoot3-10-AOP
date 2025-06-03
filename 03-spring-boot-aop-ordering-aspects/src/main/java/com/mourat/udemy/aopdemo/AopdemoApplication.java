package com.mourat.udemy.aopdemo;

import com.mourat.udemy.aopdemo.dao.AccountDAO;
import com.mourat.udemy.aopdemo.dao.MembershipDAO;
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
	public CommandLineRunner commandLineRunner(AccountDAO adao, MembershipDAO mdao){
		return runner -> {
			demoTheBeforeAdvice(adao, mdao);

		};
	}

	private void demoTheBeforeAdvice(AccountDAO adao, MembershipDAO mdao) {

		// DAOs are injected to command liner automatically (They are beans)
		// Call some functions, getters and setters of daos to test aspects
		adao.addAccount( new Account(), true);
		adao.doWork();

		adao.setName("test");
		adao.setEmail("gmail");

		adao.getEmail();
		adao.getName();

		mdao.addSillyMember();
		mdao.goToSleep();
	}
}
