package com.mbalen.demoparkapi.exception;

public class UsernameUniqueValueException extends RuntimeException {
    public UsernameUniqueValueException(String message) {
        super(message);
    }
}
