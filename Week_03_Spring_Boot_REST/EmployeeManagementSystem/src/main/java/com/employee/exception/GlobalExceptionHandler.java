package com.employee.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Catch data field binding validation failures automatically
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errorLogs = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String targetFieldName = ((FieldError) error).getField();
            String diagnosticMessage = error.getDefaultMessage();
            errorLogs.put(targetFieldName, diagnosticMessage);
        });
        return new ResponseEntity<>(errorLogs, HttpStatus.BAD_REQUEST);
    }

    // Fallback handler for raw ID missing asset errors
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgument(IllegalArgumentException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}