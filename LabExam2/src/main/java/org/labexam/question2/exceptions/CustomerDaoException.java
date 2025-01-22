package org.labexam.question2.exceptions;

public class CustomerDaoException  extends RuntimeException{
    public CustomerDaoException(String message, Throwable cause) {
        super(message);
    }
}
