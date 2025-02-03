package com.bankapp.bankapp01.controller;

import com.bankapp.bankapp01.dto.*;
import com.bankapp.bankapp01.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1"    )
public class AccountTxController {

    public AccountService accountService;
    @Autowired
    public AccountTxController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping("/transfer")
//    public String transfer(@Valid @RequestBody TransferDto transferDto) {
//        return accountService.transfer(transferDto);
    public ResponseEntity<String> transfer(@Valid @RequestBody TransferDto transferDto) {
        return ResponseEntity.ok(accountService.transfer(transferDto));

    }
    }

//    @PostMapping("/deposit")
////    public String deposit(@RequestBody DepositDto depositDto) {
////        return accountService.deposit(depositDto);
//    public ResponseEntity<String> deposit(@RequestBody DepositDto depositDto) {
//        return ResponseEntity.ok(accountService.deposit(depositDto));
//    }
//
//    @PostMapping("/withdraw")
//    public String withdraw(@RequestBody WithdrawDto withdrawDto) {
//        return accountService.withdraw(withdrawDto);
//    }
//    @PostMapping("/addAccount")
//    public ResponseEntity<AccountDto> addAccount(@RequestBody AddDto addDto) {
//        return ResponseEntity.ok(accountService.addAccount(addDto));
//    }


