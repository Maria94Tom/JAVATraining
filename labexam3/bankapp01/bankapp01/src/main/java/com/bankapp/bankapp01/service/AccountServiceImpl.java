package com.bankapp.bankapp01.service;

import com.bankapp.bankapp01.dto.*;
import com.bankapp.bankapp01.entities.Account;
import com.bankapp.bankapp01.exceptions.NotSufficientFundException;
import com.bankapp.bankapp01.repository.AccountRepo;
import com.bankapp.bankapp01.util.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private AccountRepo accountRepo;

    private Environment environment;

    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
        this.environment = environment;
    }



    @Override
    public List<AccountDto> getAllAccounts() {
        return accountRepo.findAll()
                .stream()
                .map(ConvertUtil::convertToAccountDto).toList();
    }

    @Override
    public AccountDto getAccount(int id) {
        return accountRepo.findById(id).map(ConvertUtil::convertToAccountDto).orElseThrow(() -> new RuntimeException("Account" + id + " not found"));
    }

    @Override
    public String transfer(TransferDto transferDto) {
        Account fromAccount = ConvertUtil.convertToAccount(getAccount(transferDto.getFromAccountId()));
        Account toAccount = ConvertUtil.convertToAccount(getAccount(transferDto.getToAccountId()));
        fromAccount.setBalance(fromAccount.getBalance().subtract(transferDto.getAmount()));
        accountRepo.save(fromAccount);
        accountRepo.save(toAccount);
        return environment.getProperty("transfer.success");


    }

    @Override
    public String deposit(DepositDto depositDto) {
        Account acc = ConvertUtil.convertToAccount(getAccount(depositDto.getAccountId()));
        acc.setBalance(acc.getBalance().add(depositDto.getAmount()));
        accountRepo.save(acc);
        return environment.getProperty("deposit.success");
    }

    @Override
    public String withdraw(WithdrawDto withdrawDto) {
//
//        Account acc = ConvertUtil.convertToAccount(getAccount(withdrawDto.getAccountId()));
//        if (acc.getBalance().compareTo(withdrawDto.getAmount()) >= 0) {
//            acc.setBalance(acc.getBalance().subtract(withdrawDto.getAmount()));
//            accountRepo.save(acc);
//
//        }
        Account temp = ConvertUtil.convertToAccount(getAccount(withdrawDto.getAccountId()));
        temp.setBalance(temp.getBalance().subtract(withdrawDto.getAmount()));
        BigDecimal balance = temp.getBalance();
        if(balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new NotSufficientFundException("Insufficient balance");
        }
        accountRepo.save(temp);
        return environment.getProperty("withdraw.success");
    }

//    public AddDto addAccount(AddDto addDto) {
//
//    return accountRepo.save(addDto);
//
//    }
//
//    @Override
//    public UpdateDto updateAccount(UpdateDto updateDto) {
//        return null;
//    }
//
//    @Override
//    public String deleteAccount(int id) {
//        return "";
//    }

}
