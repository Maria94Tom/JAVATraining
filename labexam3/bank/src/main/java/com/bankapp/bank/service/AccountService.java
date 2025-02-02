package com.bankapp.bank.service;

import com.bankapp.bank.entities.Account;

import java.util.List;

public interface AccountService {
public Account getById(int id);
public List<Account> getAllAccounts();
public void transferFunds(Account fromAccount, Account toAccount, int amount);
public void addAccount(Account account);
public void deleteAccount(int id);
public void withdraw(int id, int amount);
}
