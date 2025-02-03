package com.bankapp.bankapp01.controller;

import com.bankapp.bankapp01.dto.ErrorResponseDto;
import com.bankapp.bankapp01.exceptions.AccountNotFoundException;
import com.bankapp.bankapp01.exceptions.NotSufficientFundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class BankAppExceptionHandlerController {
@ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleAccountNotFoundException(AccountNotFoundException ex) {
    ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
            .errorMessage(ex.getMessage())
            .errorCode(HttpStatus.NOT_FOUND.toString())
            .toContact("Maria@thk.com")
            .timeStamp(LocalDateTime.now())
            .build();

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDto);
    }

    @ExceptionHandler(NotSufficientFundException.class)
    public ResponseEntity<ErrorResponseDto> handleNotSufficientFundException(NotSufficientFundException ex) {
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .errorMessage(ex.getMessage())
                .errorCode(HttpStatus.BAD_REQUEST.toString())
                .toContact("Maria@thk.com")
                .timeStamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDto);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
    String errorMessage = ex.getBindingResult()
            .getAllErrors()
            .stream()
            .map(error -> error.getDefaultMessage())
            .collect(Collectors.joining(", "));

        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .errorMessage(ex.getMessage())
                .errorCode(HttpStatus.BAD_REQUEST.toString())
                .toContact("Maria@thk.com")
                .timeStamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDto);
    }
}