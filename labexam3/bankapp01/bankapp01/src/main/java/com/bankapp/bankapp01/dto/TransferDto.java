package com.bankapp.bankapp01.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferDto {
    private int fromAccountId;
    private int toAccountId;
    @NotNull(message = "Balance should not be null")
    @Range(min = 100,max=10000, message = "Balance should be greater than 0")
    private BigDecimal amount;
}
