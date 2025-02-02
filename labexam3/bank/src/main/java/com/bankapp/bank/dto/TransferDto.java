package com.bankapp.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferDto {

    private int fromAccountId;
    private int toAccountId;
    private int amount;
}
