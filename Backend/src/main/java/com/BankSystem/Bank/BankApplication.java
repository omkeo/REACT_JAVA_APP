package com.BankSystem.Bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.BankSystem.Bank.Repository") // Specify the package for repositories
@EntityScan(basePackages = "com.BankSystem.Bank.Entity") 
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
		
		
		System.out.println("@@@@@@@@@@@@@@@@@@Bank application started@@@@@@@@@@@@");
		
			}

}
