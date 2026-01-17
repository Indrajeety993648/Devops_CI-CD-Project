package com.ecommerce.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exceptions for the Order Management System.
 */
public final class OrderExceptions {

    private OrderExceptions() {
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class OrderNotFoundException extends RuntimeException {
        public OrderNotFoundException(final Long id) {
            super("Order not found with ID: " + id);
        }

        public OrderNotFoundException(final String orderNumber) {
            super("Order not found with order number: " + orderNumber);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class InvalidStatusTransitionException extends RuntimeException {
        public InvalidStatusTransitionException(final String currentStatus, final String requestedStatus) {
            super("Invalid status transition from " + currentStatus + " to " + requestedStatus);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class InvalidOrderDataException extends RuntimeException {
        public InvalidOrderDataException(final String message) {
            super(message);
        }
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    public static class DuplicateOrderException extends RuntimeException {
        public DuplicateOrderException(final String orderNumber) {
            super("Order already exists with order number: " + orderNumber);
        }
    }
}
