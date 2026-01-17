package com.ecommerce.order.exception;

import com.ecommerce.order.dto.OrderDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

/**
 * Global exception handler for the Order Management API.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(OrderExceptions.OrderNotFoundException.class)
    public ResponseEntity<OrderDto.ErrorResponse> handleOrderNotFound(
            final OrderExceptions.OrderNotFoundException ex,
            final WebRequest request) {
        LOGGER.warn("Order not found: {}", ex.getMessage());
        OrderDto.ErrorResponse error = OrderDto.ErrorResponse.builder()
                .message(ex.getMessage())
                .errorCode("ORDER_NOT_FOUND")
                .timestamp(LocalDateTime.now())
                .path(request.getDescription(false))
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(OrderExceptions.InvalidStatusTransitionException.class)
    public ResponseEntity<OrderDto.ErrorResponse> handleInvalidStatusTransition(
            final OrderExceptions.InvalidStatusTransitionException ex,
            final WebRequest request) {
        LOGGER.warn("Invalid status transition: {}", ex.getMessage());
        OrderDto.ErrorResponse error = OrderDto.ErrorResponse.builder()
                .message(ex.getMessage())
                .errorCode("INVALID_STATUS_TRANSITION")
                .timestamp(LocalDateTime.now())
                .path(request.getDescription(false))
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<OrderDto.ErrorResponse> handleValidationErrors(
            final MethodArgumentNotValidException ex,
            final WebRequest request) {
        String errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));
        LOGGER.warn("Validation failed: {}", errors);
        OrderDto.ErrorResponse error = OrderDto.ErrorResponse.builder()
                .message("Validation failed: " + errors)
                .errorCode("VALIDATION_ERROR")
                .timestamp(LocalDateTime.now())
                .path(request.getDescription(false))
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<OrderDto.ErrorResponse> handleGenericException(
            final Exception ex,
            final WebRequest request) {
        LOGGER.error("Unexpected error occurred", ex);
        OrderDto.ErrorResponse error = OrderDto.ErrorResponse.builder()
                .message("An unexpected error occurred. Please try again later.")
                .errorCode("INTERNAL_ERROR")
                .timestamp(LocalDateTime.now())
                .path(request.getDescription(false))
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
