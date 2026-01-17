package com.ecommerce.order.service;

import com.ecommerce.order.config.OrderStateMachine;
import com.ecommerce.order.dto.OrderDto;
import com.ecommerce.order.exception.OrderExceptions;
import com.ecommerce.order.mapper.OrderMapper;
import com.ecommerce.order.model.Order;
import com.ecommerce.order.model.OrderStatus;
import com.ecommerce.order.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service layer for Order business logic.
 */
@Service
@Transactional
public class OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderStateMachine stateMachine;

    public OrderService(final OrderRepository orderRepository,
                        final OrderMapper orderMapper,
                        final OrderStateMachine stateMachine) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.stateMachine = stateMachine;
    }

    public OrderDto.OrderResponse createOrder(final OrderDto.CreateOrderRequest request) {
        LOGGER.info("Creating new order for customer: {}", request.getCustomerEmail());
        Order order = orderMapper.toEntity(request);
        order.setStatus(OrderStatus.PENDING);
        Order savedOrder = orderRepository.save(order);
        LOGGER.info("Order created successfully: {}", savedOrder.getOrderNumber());
        return orderMapper.toResponse(savedOrder);
    }

    @Transactional(readOnly = true)
    public OrderDto.OrderResponse getOrderById(final Long id) {
        LOGGER.debug("Fetching order by ID: {}", id);
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderExceptions.OrderNotFoundException(id));
        return orderMapper.toResponse(order);
    }

    @Transactional(readOnly = true)
    public OrderDto.OrderResponse getOrderByOrderNumber(final String orderNumber) {
        LOGGER.debug("Fetching order by order number: {}", orderNumber);
        Order order = orderRepository.findByOrderNumber(orderNumber)
                .orElseThrow(() -> new OrderExceptions.OrderNotFoundException(orderNumber));
        return orderMapper.toResponse(order);
    }

    @Transactional(readOnly = true)
    public List<OrderDto.OrderResponse> getAllOrders() {
        LOGGER.debug("Fetching all orders");
        List<Order> orders = orderRepository.findAll();
        return orderMapper.toResponseList(orders);
    }

    @Transactional(readOnly = true)
    public List<OrderDto.OrderResponse> getOrdersByStatus(final OrderStatus status) {
        LOGGER.debug("Fetching orders by status: {}", status);
        List<Order> orders = orderRepository.findByStatusOrderByCreatedAtDesc(status);
        return orderMapper.toResponseList(orders);
    }

    @Transactional(readOnly = true)
    public List<OrderDto.OrderResponse> getOrdersByCustomerEmail(final String email) {
        LOGGER.debug("Fetching orders for customer: {}", email);
        List<Order> orders = orderRepository.findByCustomerEmailOrderByCreatedAtDesc(email);
        return orderMapper.toResponseList(orders);
    }

    public OrderDto.OrderResponse updateOrderStatus(final Long id,
            final OrderDto.UpdateStatusRequest request) {
        LOGGER.info("Updating status for order ID: {} to {}", id, request.getStatus());
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderExceptions.OrderNotFoundException(id));

        if (!stateMachine.isValidTransition(order.getStatus(), request.getStatus())) {
            throw new OrderExceptions.InvalidStatusTransitionException(
                    order.getStatus().name(), request.getStatus().name());
        }

        order.setStatus(request.getStatus());
        if (request.getNotes() != null && !request.getNotes().isEmpty()) {
            String updatedNotes = order.getNotes() == null ? "" : order.getNotes() + "\n";
            order.setNotes(updatedNotes + "[Status Update] " + request.getNotes());
        }

        Order updatedOrder = orderRepository.save(order);
        LOGGER.info("Order {} status updated to {}", order.getOrderNumber(), request.getStatus());
        return orderMapper.toResponse(updatedOrder);
    }

    public OrderDto.OrderResponse cancelOrder(final Long id) {
        LOGGER.info("Cancelling order ID: {}", id);
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderExceptions.OrderNotFoundException(id));

        if (!stateMachine.canCancel(order.getStatus())) {
            throw new OrderExceptions.InvalidStatusTransitionException(
                    order.getStatus().name(), OrderStatus.CANCELLED.name());
        }

        order.setStatus(OrderStatus.CANCELLED);
        Order cancelledOrder = orderRepository.save(order);
        LOGGER.info("Order {} cancelled successfully", order.getOrderNumber());
        return orderMapper.toResponse(cancelledOrder);
    }

    public void deleteOrder(final Long id) {
        LOGGER.warn("Deleting order ID: {}", id);
        if (!orderRepository.existsById(id)) {
            throw new OrderExceptions.OrderNotFoundException(id);
        }
        orderRepository.deleteById(id);
        LOGGER.info("Order {} deleted", id);
    }
}
