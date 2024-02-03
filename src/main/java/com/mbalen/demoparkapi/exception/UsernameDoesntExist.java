package com.mbalen.demoparkapi.exception;

public class UsernameDoesntExist extends RuntimeException {
    public UsernameDoesntExist(String message) {
        super(message);
    }
}
