package com.bankapp.bankapp01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepositDto {
    private int accountId;
    private BigDecimal amount;
}
