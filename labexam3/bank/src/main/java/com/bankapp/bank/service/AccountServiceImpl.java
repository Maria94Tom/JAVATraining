package com.bankapp.bank.service;

import com.bankapp.bank.entities.Account;
import com.bankapp.bank.exceptions.AccountNotFoundException;
import com.bankapp.bank.repo.AccountRepo;
import com.bankapp.bank.service.aspect.Loggable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepo accountRepo;

    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    @Loggable
    public Account getById(int id) {
        return accountRepo.findById(id).orElseThrow(() -> new AccountNotFoundException("Account not found"));
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }
    @Transactional
    @Loggable
    @Override
    public void transferFunds(Account fromAccount, Account toAccount, int amount) {
        if (fromAccount.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds in the fromAccount");
        }
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
        if(fromAccount.getBalance() - amount < 1000)
        {
            throw new IllegalArgumentException("Minimum balance should be 1000");
        }
        accountRepo.save(fromAccount);
        accountRepo.save(toAccount);
    }

    @Override
    @Loggable
    public void addAccount(Account account) {
        accountRepo.save(account);


    }

    @Override
    public void deleteAccount(int id) {
        accountRepo.deleteById(id);

    }

    @Override
    @Loggable
    public void withdraw(int id, int amount) {
        Account account = accountRepo.findById(id).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        if (account.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds in the account");
        }
        account.setBalance(account.getBalance() - amount);
        accountRepo.save(account);


    }
}
