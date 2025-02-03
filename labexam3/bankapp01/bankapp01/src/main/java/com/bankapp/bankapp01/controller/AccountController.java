package com.bankapp.bankapp01.controller;

import com.bankapp.bankapp01.dto.AccountDto;
import com.bankapp.bankapp01.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<AccountDto> getAccount(int id) {
        return ResponseEntity.ok(accountService.getAccount(id));
    }



}
