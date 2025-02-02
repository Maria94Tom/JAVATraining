package com.bankapp.bank;

import com.bankapp.bank.entities.Account;
import com.bankapp.bank.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BankApplication implements CommandLineRunner {
@Autowired
private AccountRepo accountRepo;

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		accountRepo.save(new Account("Maria", 1000));
//		accountRepo.save(new Account("Tibin", 2000));


	}
}
