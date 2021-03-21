package com.SpringDataJpa.TransanctionalExample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.SpringDataJpa.TransanctionalExample.model.Account;
import com.SpringDataJpa.TransanctionalExample.service.BankService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	private BankService bankService;
	
	public DemoApplication(BankService bankService) {
		super();
		this.bankService = bankService;
	}

	@Override
	public void run(String... args) throws Exception {
		Account account1 = new Account();
		Account account2 = new Account();
		
		account1.setAccountNum(12341234L);
		account2.setAccountNum(56785678L);
		
		
		bankService.transferFunds(account1, account2, 1000L);
		
	}

}
