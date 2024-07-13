package com.alura.forohub.domain.infra.errors;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

public class ErrorHandling {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> handle404Error() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrorDetails>> handle400Error(MethodArgumentNotValidException e) {
        var errors = e.getFieldErrors().stream().map(ValidationErrorDetails::new).toList();
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(IntegrityValidationException.class)
    public ResponseEntity<String> handleIntegrityValidationError(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleBusinessValidationError(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    private record ValidationErrorDetails(String field, String error) {
        public ValidationErrorDetails(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}

