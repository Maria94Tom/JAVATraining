package com.bankapp.bank.controller;

import com.bankapp.bank.entities.Account;
import com.bankapp.bank.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
 private AccountService accountService;

 @Autowired
 public AccountController(AccountService accountService) {
  this.accountService = accountService;
 }

@GetMapping("/accounts")
// public List<Account> getAllAccounts() {
//  return accountService.getAllAccounts();
// }

public ResponseEntity<List<Account>> getAllAccounts() {
 return ResponseEntity.status(HttpStatus.OK).body(accountService.getAllAccounts());
}

 @GetMapping("/accounts/{id}")
 public ResponseEntity<Account> getById(@PathVariable int id) {
  return ResponseEntity.status(HttpStatus.OK).body(accountService.getById(id));
 }

@PostMapping("/accounts")
 public ResponseEntity<Void> addAccount(@RequestBody @Valid Account account) {
  accountService.addAccount(account);
  return ResponseEntity.status(HttpStatus.CREATED).build();
 }

 @PutMapping("/accounts/withdraw/{id}")
 public ResponseEntity<Void> withdraw(@PathVariable int id,  @RequestParam int amount) {
  accountService.withdraw(id, amount);
  return ResponseEntity.status(HttpStatus.OK).build();
 }

 @Operation(
         summary = "Transfer between accounts",
         description = "Debit from payer and credit in payee.",
         tags = { "AccountController", "put" })
 @ApiResponses({
         @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Account.class),
                 mediaType = "application/json") }),
         @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
         @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
 @PutMapping("/accounts/transfer")
 public ResponseEntity<Void> transferFunds(@RequestParam @Valid int fromAccountId, @RequestParam @Valid int toAccountId, @RequestParam @Valid int amount) {
  accountService.transferFunds(accountService.getById(fromAccountId), accountService.getById(toAccountId), amount);
  return ResponseEntity.status(HttpStatus.OK).build();
 }

@DeleteMapping("/accounts/{id}")
public ResponseEntity<Void> deleteAccount(@PathVariable int id) {
 accountService.deleteAccount(id);
 return ResponseEntity.status(HttpStatus.OK).build();
}
}
