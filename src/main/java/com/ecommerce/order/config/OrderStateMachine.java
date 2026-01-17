package com.ecommerce.order.config;

import com.ecommerce.order.model.OrderStatus;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

/**
 * State Machine configuration for Order status transitions.
 */
@Component
public class OrderStateMachine {

    private final Map<OrderStatus, Set<OrderStatus>> allowedTransitions;

    public OrderStateMachine() {
        this.allowedTransitions = new EnumMap<>(OrderStatus.class);
        initializeTransitions();
    }

    private void initializeTransitions() {
        allowedTransitions.put(OrderStatus.PENDING, EnumSet.of(
                OrderStatus.CONFIRMED,
                OrderStatus.CANCELLED
        ));

        allowedTransitions.put(OrderStatus.CONFIRMED, EnumSet.of(
                OrderStatus.PROCESSING,
                OrderStatus.CANCELLED
        ));

        allowedTransitions.put(OrderStatus.PROCESSING, EnumSet.of(
                OrderStatus.SHIPPED,
                OrderStatus.CANCELLED
        ));

        allowedTransitions.put(OrderStatus.SHIPPED, EnumSet.of(
                OrderStatus.DELIVERED
        ));

        allowedTransitions.put(OrderStatus.DELIVERED, EnumSet.noneOf(OrderStatus.class));
        allowedTransitions.put(OrderStatus.CANCELLED, EnumSet.noneOf(OrderStatus.class));
    }

    public boolean isValidTransition(final OrderStatus fromStatus, final OrderStatus toStatus) {
        if (fromStatus == toStatus) {
            return true;
        }
        Set<OrderStatus> validTargets = allowedTransitions.get(fromStatus);
        return validTargets != null && validTargets.contains(toStatus);
    }

    public Set<OrderStatus> getValidNextStatuses(final OrderStatus currentStatus) {
        return allowedTransitions.getOrDefault(currentStatus, EnumSet.noneOf(OrderStatus.class));
    }

    public boolean isTerminalState(final OrderStatus status) {
        Set<OrderStatus> validTargets = allowedTransitions.get(status);
        return validTargets == null || validTargets.isEmpty();
    }

    public boolean canCancel(final OrderStatus currentStatus) {
        return isValidTransition(currentStatus, OrderStatus.CANCELLED);
    }
}
