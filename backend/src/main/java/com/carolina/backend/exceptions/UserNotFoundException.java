package com.carolina.backend.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message, Throwable error) {
        super(message, error);
    }
}
