package com.carolina.backend.exceptions;

public class InvalidAuthenticationException extends RuntimeException {
    public InvalidAuthenticationException(String message, Throwable error) {
        super(message, error);
    }
}
