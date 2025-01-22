package org.labexam.question2.exceptions;

public class CustomerNotFoundException extends  RuntimeException{
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
