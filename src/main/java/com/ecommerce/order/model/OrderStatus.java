package com.ecommerce.order.model;

/**
 * Enumeration representing the possible states of an order.
 */
public enum OrderStatus {

    PENDING("Pending", "Order is awaiting confirmation"),
    CONFIRMED("Confirmed", "Order confirmed, awaiting processing"),
    PROCESSING("Processing", "Order is being prepared"),
    SHIPPED("Shipped", "Order has been shipped"),
    DELIVERED("Delivered", "Order delivered successfully"),
    CANCELLED("Cancelled", "Order has been cancelled");

    private final String displayName;
    private final String description;

    OrderStatus(final String displayName, final String description) {
        this.displayName = displayName;
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }
}
