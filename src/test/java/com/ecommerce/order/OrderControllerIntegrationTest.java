package com.ecommerce.order;

import com.ecommerce.order.dto.OrderDto;
import com.ecommerce.order.model.Order;
import com.ecommerce.order.model.OrderStatus;
import com.ecommerce.order.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Order Controller Integration Tests")
class OrderControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderRepository.deleteAll();
    }

    @Nested
    @DisplayName("POST /api/v1/orders")
    class CreateOrderEndpoint {
        @Test
        @DisplayName("Should create order with valid data")
        void shouldCreateOrderWithValidData() throws Exception {
            OrderDto.CreateOrderRequest request = OrderDto.CreateOrderRequest.builder()
                    .customerName("John Doe")
                    .customerEmail("john@example.com")
                    .productId("PROD-001")
                    .productName("Wireless Mouse")
                    .quantity(2)
                    .unitPrice(new BigDecimal("29.99"))
                    .shippingAddress("123 Main St, City, 12345")
                    .build();

            mockMvc.perform(post("/api/v1/orders")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.orderNumber", notNullValue()))
                    .andExpect(jsonPath("$.customerName", is("John Doe")))
                    .andExpect(jsonPath("$.status", is("PENDING")));
        }

        @Test
        @DisplayName("Should reject invalid request")
        void shouldRejectInvalidRequest() throws Exception {
            OrderDto.CreateOrderRequest request = OrderDto.CreateOrderRequest.builder()
                    .customerName("")
                    .customerEmail("invalid-email")
                    .build();

            mockMvc.perform(post("/api/v1/orders")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.errorCode", is("VALIDATION_ERROR")));
        }
    }

    @Nested
    @DisplayName("GET /api/v1/orders")
    class GetOrdersEndpoint {
        @Test
        @DisplayName("Should return empty list when no orders")
        void shouldReturnEmptyList() throws Exception {
            mockMvc.perform(get("/api/v1/orders"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(0)));
        }

        @Test
        @DisplayName("Should return all orders")
        void shouldReturnAllOrders() throws Exception {
            createTestOrder("John Doe", "john@example.com");
            createTestOrder("Jane Smith", "jane@example.com");

            mockMvc.perform(get("/api/v1/orders"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(2)));
        }
    }

    @Nested
    @DisplayName("GET /api/v1/orders/{id}")
    class GetOrderByIdEndpoint {
        @Test
        @DisplayName("Should return order when found")
        void shouldReturnOrderWhenFound() throws Exception {
            Order order = createTestOrder("John Doe", "john@example.com");

            mockMvc.perform(get("/api/v1/orders/" + order.getId()))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.customerName", is("John Doe")));
        }

        @Test
        @DisplayName("Should return 404 when not found")
        void shouldReturn404WhenNotFound() throws Exception {
            mockMvc.perform(get("/api/v1/orders/999"))
                    .andExpect(status().isNotFound())
                    .andExpect(jsonPath("$.errorCode", is("ORDER_NOT_FOUND")));
        }
    }

    @Nested
    @DisplayName("PUT /api/v1/orders/{id}/cancel")
    class CancelOrderEndpoint {
        @Test
        @DisplayName("Should cancel PENDING order")
        void shouldCancelPendingOrder() throws Exception {
            Order order = createTestOrder("John Doe", "john@example.com");

            mockMvc.perform(put("/api/v1/orders/" + order.getId() + "/cancel"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.status", is("CANCELLED")));
        }
    }

    @Nested
    @DisplayName("GET /api/v1/orders/health")
    class HealthCheckEndpoint {
        @Test
        @DisplayName("Should return health status")
        void shouldReturnHealthStatus() throws Exception {
            mockMvc.perform(get("/api/v1/orders/health"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.status", is("UP")))
                    .andExpect(jsonPath("$.service", is("order-management-system")));
        }
    }

    private Order createTestOrder(String customerName, String customerEmail) {
        Order order = Order.builder()
                .customerName(customerName)
                .customerEmail(customerEmail)
                .productId("PROD-001")
                .productName("Test Product")
                .quantity(1)
                .unitPrice(new BigDecimal("99.99"))
                .totalAmount(new BigDecimal("99.99"))
                .shippingAddress("123 Test St")
                .status(OrderStatus.PENDING)
                .build();
        return orderRepository.save(order);
    }
}
