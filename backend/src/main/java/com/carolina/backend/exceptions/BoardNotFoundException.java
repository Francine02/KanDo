package com.carolina.backend.exceptions;

public class BoardNotFoundException extends RuntimeException {
    public BoardNotFoundException(String message, Throwable error) {
        super(message, error);
    }
}
