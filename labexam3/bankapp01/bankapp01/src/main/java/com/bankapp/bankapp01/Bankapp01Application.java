package com.bankapp.bankapp01;

import com.bankapp.bankapp01.entities.Account;
import com.bankapp.bankapp01.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class Bankapp01Application implements CommandLineRunner {
	@Autowired
	private AccountRepo accountRepo;
	public static void main(String[] args) {
		SpringApplication.run(Bankapp01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//This method overriden when BanlApp01Application run
		accountRepo.save(new Account("John", new BigDecimal(1000.00)));
		accountRepo.save(new Account("Jane", new BigDecimal(2000.00)));

	}

}
