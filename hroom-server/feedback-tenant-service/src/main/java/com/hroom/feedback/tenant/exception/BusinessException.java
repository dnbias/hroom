package com.hroom.feedback.tenant.exception;

public class BusinessException extends Exception {
    public BusinessException() {
        super();
    }

    public BusinessException(final String message) {
        super(message);
    }
}
