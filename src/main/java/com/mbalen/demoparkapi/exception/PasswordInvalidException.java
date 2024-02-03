package com.mbalen.demoparkapi.exception;

public class PasswordInvalidException extends RuntimeException {
    public PasswordInvalidException(String error) {
        super(error);
    }
}
