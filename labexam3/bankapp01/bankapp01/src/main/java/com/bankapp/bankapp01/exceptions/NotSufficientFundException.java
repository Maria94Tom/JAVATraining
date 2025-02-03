package com.bankapp.bankapp01.exceptions;

public class NotSufficientFundException extends RuntimeException{
    public NotSufficientFundException(String message) {
        super(message);
    }
}
