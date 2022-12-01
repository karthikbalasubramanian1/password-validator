package com.example.domain.exception;

/**
 * Exception thrown when password violating the standards was processed
 */
public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
