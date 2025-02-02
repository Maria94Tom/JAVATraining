package com.bankapp.bank.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "account")
public class Account {
@Id
@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
@NotEmpty(message = "{account.name.absent}")
    private String name;
@NotNull(message = "{account.balance.absent}")
@Range(min=1000,message = "{account.balance.invalid}")
    private int balance;

    public Account(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }
}
