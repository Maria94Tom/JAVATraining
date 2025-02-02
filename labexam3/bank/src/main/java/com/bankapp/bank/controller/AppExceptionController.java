package com.bankapp.bank.controller;

import com.bankapp.bank.dto.ErrorMessages;
import com.bankapp.bank.exceptions.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class AppExceptionController {

    @Value("${PRODUCT_APP_ERROR_500}")
    private String message500;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessages> handleException400(MethodArgumentNotValidException ex) {
        //i want to get exact response
        String message=ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.joining(" ,"));

        ErrorMessages errorMessages = ErrorMessages
                .builder().timestamp(LocalDateTime.now())
                .status(400).
                message(message)
                .toContact("maria@thk.com")
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
    }

    //@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessages> handleException500(Exception ex) {
        ErrorMessages errorMessages = ErrorMessages
                .builder().timestamp(LocalDateTime.now())
                .status(500).
                message(message500)
                .toContact("ravi@abc.com")
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessages);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorMessages> handleException404(AccountNotFoundException ex) {

        ErrorMessages errorMessages = ErrorMessages
                .builder().timestamp(LocalDateTime.now())
                .status(404).
                message(ex.getMessage())
                .toContact("maria@thk.com")
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessages);

    }


}
