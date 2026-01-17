package com.ecommerce.order.controller;

import com.ecommerce.order.dto.OrderDto;
import com.ecommerce.order.model.OrderStatus;
import com.ecommerce.order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

/**
 * REST Controller for Order Management API.
 */
@RestController
@RequestMapping("/api/v1/orders")
@Tag(name = "Order Management", description = "APIs for managing e-commerce orders")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;

    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @Operation(summary = "Create a new order")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Order created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public ResponseEntity<OrderDto.OrderResponse> createOrder(
            @Valid @RequestBody final OrderDto.CreateOrderRequest request) {
        LOGGER.info("POST /api/v1/orders - Creating order for: {}", request.getCustomerEmail());
        OrderDto.OrderResponse response = orderService.createOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    @Operation(summary = "Get all orders")
    public ResponseEntity<List<OrderDto.OrderResponse>> getAllOrders() {
        LOGGER.info("GET /api/v1/orders - Fetching all orders");
        List<OrderDto.OrderResponse> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get order by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Order found"),
        @ApiResponse(responseCode = "404", description = "Order not found")
    })
    public ResponseEntity<OrderDto.OrderResponse> getOrderById(
            @Parameter(description = "Order ID") @PathVariable final Long id) {
        LOGGER.info("GET /api/v1/orders/{} - Fetching order", id);
        OrderDto.OrderResponse order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/number/{orderNumber}")
    @Operation(summary = "Get order by order number")
    public ResponseEntity<OrderDto.OrderResponse> getOrderByOrderNumber(
            @PathVariable final String orderNumber) {
        LOGGER.info("GET /api/v1/orders/number/{} - Fetching order", orderNumber);
        OrderDto.OrderResponse order = orderService.getOrderByOrderNumber(orderNumber);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/status/{status}")
    @Operation(summary = "Get orders by status")
    public ResponseEntity<List<OrderDto.OrderResponse>> getOrdersByStatus(
            @PathVariable final OrderStatus status) {
        LOGGER.info("GET /api/v1/orders/status/{} - Fetching orders", status);
        List<OrderDto.OrderResponse> orders = orderService.getOrdersByStatus(status);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/customer")
    @Operation(summary = "Get orders by customer email")
    public ResponseEntity<List<OrderDto.OrderResponse>> getOrdersByCustomerEmail(
            @RequestParam final String email) {
        LOGGER.info("GET /api/v1/orders/customer?email={} - Fetching orders", email);
        List<OrderDto.OrderResponse> orders = orderService.getOrdersByCustomerEmail(email);
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/{id}/status")
    @Operation(summary = "Update order status")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Status updated successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid status transition"),
        @ApiResponse(responseCode = "404", description = "Order not found")
    })
    public ResponseEntity<OrderDto.OrderResponse> updateOrderStatus(
            @PathVariable final Long id,
            @Valid @RequestBody final OrderDto.UpdateStatusRequest request) {
        LOGGER.info("PUT /api/v1/orders/{}/status - Updating to {}", id, request.getStatus());
        OrderDto.OrderResponse order = orderService.updateOrderStatus(id, request);
        return ResponseEntity.ok(order);
    }

    @PutMapping("/{id}/cancel")
    @Operation(summary = "Cancel an order")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Order cancelled successfully"),
        @ApiResponse(responseCode = "400", description = "Order cannot be cancelled"),
        @ApiResponse(responseCode = "404", description = "Order not found")
    })
    public ResponseEntity<OrderDto.OrderResponse> cancelOrder(@PathVariable final Long id) {
        LOGGER.info("PUT /api/v1/orders/{}/cancel - Cancelling order", id);
        OrderDto.OrderResponse order = orderService.cancelOrder(id);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an order")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Order deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Order not found")
    })
    public ResponseEntity<Void> deleteOrder(@PathVariable final Long id) {
        LOGGER.warn("DELETE /api/v1/orders/{} - Deleting order", id);
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/health")
    @Operation(summary = "Health check")
    public ResponseEntity<HealthResponse> healthCheck() {
        HealthResponse health = HealthResponse.builder()
                .status("UP")
                .service("order-management-system")
                .timestamp(LocalDateTime.now())
                .version("1.0.0")
                .build();
        return ResponseEntity.ok(health);
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HealthResponse {
        private String status;
        private String service;
        private LocalDateTime timestamp;
        private String version;
    }
}
