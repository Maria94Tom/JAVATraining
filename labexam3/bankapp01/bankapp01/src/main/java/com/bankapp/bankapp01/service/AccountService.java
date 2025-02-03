package com.bankapp.bankapp01.service;

import com.bankapp.bankapp01.dto.*;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    public List<AccountDto> getAllAccounts();
    public AccountDto getAccount(int id);
    public String transfer(TransferDto transferDto);
    public String deposit(DepositDto depositDto);
    public String withdraw(WithdrawDto withdrawDto);
//    public AddDto addAccount(AddDto addDto);
//    public UpdateDto updateAccount(UpdateDto updateDto);
//    public String deleteAccount(int id);
}
