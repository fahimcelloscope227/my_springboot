package com.example.ecom_app.basic_ecom.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.ecom_app.basic_ecom.adapter.input.dto.ApiResponse;
import com.example.ecom_app.basic_ecom.domain.exceptions.InvalidCredentialsException;
import com.example.ecom_app.basic_ecom.domain.exceptions.UserAlreadyExistsException;

import jakarta.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

        private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

        // Handle missing or malformed JSON body
        @ExceptionHandler(HttpMessageNotReadableException.class)
        public ResponseEntity<ApiResponse> handleMissingBody(HttpMessageNotReadableException ex) {
                log.warn("Malformed or missing request body: {}", ex.getMessage());
                String msg = "Request body is missing or malformed JSON";
                return ResponseEntity.badRequest().body(
                                ApiResponse.builder()
                                                .success(false)
                                                .message(msg)
                                                .data(null)
                                                .build());
        }

        // Handle validation errors for @Valid request bodies
        @ExceptionHandler(MethodArgumentNotValidException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public ResponseEntity<ApiResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
                String errors = ex.getBindingResult().getFieldErrors().stream()
                                .map(fe -> fe.getField() + ": " + fe.getDefaultMessage())
                                .collect(Collectors.joining("; "));
                String msg = errors.isEmpty() ? "Validation failed" : "Validation failed: " + errors;
                log.warn("Validation failed: {}", errors);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                                ApiResponse.builder()
                                                .success(false)
                                                .message(msg)
                                                .data(null)
                                                .build());
        }

        // Handle ConstraintViolationException (e.g., path/param validations)
        @ExceptionHandler(ConstraintViolationException.class)
        public ResponseEntity<ApiResponse> handleConstraintViolation(ConstraintViolationException ex) {
                String errors = ex.getConstraintViolations().stream()
                                .map(cv -> cv.getPropertyPath() + ": " + cv.getMessage())
                                .collect(Collectors.joining("; "));
                log.warn("Constraint violations: {}", errors);
                String msg = errors.isEmpty() ? "Constraint violation" : "Constraint violation: " + errors;
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                                ApiResponse.builder().success(false).message(msg).data(null).build());
        }

        // Handle illegal arguments thrown by service/adapters
        @ExceptionHandler(IllegalArgumentException.class)
        public ResponseEntity<ApiResponse> handleIllegalArgument(IllegalArgumentException ex) {
                log.warn("Illegal argument: {}", ex.getMessage());
                String msg = ex.getMessage() == null ? "Invalid request" : ex.getMessage();
                return ResponseEntity.badRequest().body(
                                ApiResponse.builder().success(false).message(msg).data(null).build());
        }

        // Domain-specific exceptions
        @ExceptionHandler(InvalidCredentialsException.class)
        public ResponseEntity<ApiResponse> handleInvalidCredentials(RuntimeException ex) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                                ApiResponse.builder().success(false).message(ex.getMessage()).data(null).build());
        }

        @ExceptionHandler(UserAlreadyExistsException.class)
        public ResponseEntity<ApiResponse> handleUserExists(RuntimeException ex) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(
                                ApiResponse.builder().success(false).message(ex.getMessage()).data(null).build());
        }

        @ExceptionHandler(com.example.ecom_app.products.domain.exceptions.RateLimitExceededException.class)
        public ResponseEntity<ApiResponse> handleRateLimitExceeded(RuntimeException ex) {
                return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(
                                ApiResponse.builder()
                                                .success(false)
                                                .message(ex.getMessage())
                                                .data(null)
                                                .build());
        }

        // Fallback
        @ExceptionHandler(Exception.class)
        public ResponseEntity<ApiResponse> handleAll(Exception ex) {
                log.error("Unhandled exception occurred", ex);
                String message = "Internal server error: " + ex.getMessage();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                                ApiResponse.builder().success(false).message(message).data(null).build());
        }
}
