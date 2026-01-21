package com.assistant;

/**
 * Custom exception for invalid commands.
 * Demonstrates user-defined exception handling.
 */
public class InvalidCommandException extends Exception {

    public InvalidCommandException(String message) {
        super(message);
    }

    public InvalidCommandException(String message, Throwable cause) {
        super(message, cause);
    }
}
