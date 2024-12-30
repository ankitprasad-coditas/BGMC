package com.project4.BGMC.exceptions;

public class CompanyCreationException extends RuntimeException {

    public CompanyCreationException(String message) {
        super(message);
    }

    public CompanyCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public CompanyCreationException(Throwable cause) {
        super(cause);
    }
}