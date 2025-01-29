package com.employee.controller;

import com.employee.exceptions.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExHandler {
@ExceptionHandler(EmployeeNotFoundException.class)
public ResponseEntity<ErrorDetails> handle404   (EmployeeNotFoundException ex) {
    ErrorDetails errorDetails = new ErrorDetails();
  //errorDetails.setMessage(ex.getMessage());
   // errorDetails.setStatus(404);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
}

}
