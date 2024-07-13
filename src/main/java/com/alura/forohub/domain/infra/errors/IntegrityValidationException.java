package com.alura.forohub.domain.infra.errors;

public class IntegrityValidationException extends RuntimeException {
    public IntegrityValidationException(String message) {
        super(message);
    }
}

