package com.bankapp.bankapp01.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private int id;
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotNull(message = "Balance should not be null")
    @Range(min = 0, message = "Balance should be greater than 0")
    private BigDecimal balance;


    public AccountDto(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance;
    }
}
