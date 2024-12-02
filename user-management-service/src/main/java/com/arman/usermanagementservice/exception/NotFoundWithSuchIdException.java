package com.arman.usermanagementservice.exception;

public class NotFoundWithSuchIdException extends RuntimeException {
    public NotFoundWithSuchIdException(String message) {
        super(message);
    }
}
