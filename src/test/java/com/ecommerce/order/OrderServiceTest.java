package com.ecommerce.order;

import com.ecommerce.order.config.OrderStateMachine;
import com.ecommerce.order.dto.OrderDto;
import com.ecommerce.order.exception.OrderExceptions;
import com.ecommerce.order.mapper.OrderMapper;
import com.ecommerce.order.model.Order;
import com.ecommerce.order.model.OrderStatus;
import com.ecommerce.order.repository.OrderRepository;
import com.ecommerce.order.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;

@ExtendWith(MockitoExtension.class)
@DisplayName("Order Service Tests")
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderMapper orderMapper;

    private OrderStateMachine stateMachine;
    private OrderService orderService;
    private Order testOrder;
    private OrderDto.OrderResponse orderResponse;

    @BeforeEach
    void setUp() {
        stateMachine = new OrderStateMachine();
        orderService = new OrderService(orderRepository, orderMapper, stateMachine);

        testOrder = Order.builder()
                .id(1L)
                .orderNumber("ORD-12345678")
                .customerName("John Doe")
                .customerEmail("john.doe@example.com")
                .status(OrderStatus.PENDING)
                .createdAt(LocalDateTime.now())
                .build();

        orderResponse = OrderDto.OrderResponse.builder()
                .id(1L)
                .orderNumber("ORD-12345678")
                .customerName("John Doe")
                .status(OrderStatus.PENDING)
                .build();
    }

    @Nested
    @DisplayName("Create Order Tests")
    class CreateOrderTests {
        @Test
        @DisplayName("Should create order successfully")
        void shouldCreateOrderSuccessfully() {
            OrderDto.CreateOrderRequest request = OrderDto.CreateOrderRequest.builder()
                    .customerName("John Doe")
                    .customerEmail("john@example.com")
                    .productId("PROD-001")
                    .productName("Laptop")
                    .quantity(1)
                    .unitPrice(new BigDecimal("999.99"))
                    .shippingAddress("123 Main St")
                    .build();

            when(orderMapper.toEntity(any())).thenReturn(testOrder);
            when(orderRepository.save(any())).thenReturn(testOrder);
            when(orderMapper.toResponse(any())).thenReturn(orderResponse);

            OrderDto.OrderResponse response = orderService.createOrder(request);

            assertThat(response).isNotNull();
            verify(orderRepository).save(any(Order.class));
        }
    }

    @Nested
    @DisplayName("Get Order Tests")
    class GetOrderTests {
        @Test
        @DisplayName("Should return order when found by ID")
        void shouldReturnOrderWhenFoundById() {
            when(orderRepository.findById(1L)).thenReturn(Optional.of(testOrder));
            when(orderMapper.toResponse(testOrder)).thenReturn(orderResponse);

            OrderDto.OrderResponse response = orderService.getOrderById(1L);

            assertThat(response).isNotNull();
            assertThat(response.getId()).isEqualTo(1L);
        }

        @Test
        @DisplayName("Should throw exception when order not found")
        void shouldThrowExceptionWhenOrderNotFound() {
            when(orderRepository.findById(999L)).thenReturn(Optional.empty());

            assertThatThrownBy(() -> orderService.getOrderById(999L))
                    .isInstanceOf(OrderExceptions.OrderNotFoundException.class);
        }

        @Test
        @DisplayName("Should return all orders")
        void shouldReturnAllOrders() {
            when(orderRepository.findAll()).thenReturn(Arrays.asList(testOrder));
            when(orderMapper.toResponseList(any())).thenReturn(Arrays.asList(orderResponse));

            List<OrderDto.OrderResponse> result = orderService.getAllOrders();

            assertThat(result).hasSize(1);
        }
    }

    @Nested
    @DisplayName("Cancel Order Tests")
    class CancelOrderTests {
        @Test
        @DisplayName("Should cancel PENDING order")
        void shouldCancelPendingOrder() {
            testOrder.setStatus(OrderStatus.PENDING);
            when(orderRepository.findById(1L)).thenReturn(Optional.of(testOrder));
            when(orderRepository.save(any())).thenReturn(testOrder);
            when(orderMapper.toResponse(any())).thenReturn(orderResponse);

            orderService.cancelOrder(1L);

            verify(orderRepository).save(any(Order.class));
        }

        @Test
        @DisplayName("Should not cancel SHIPPED order")
        void shouldNotCancelShippedOrder() {
            testOrder.setStatus(OrderStatus.SHIPPED);
            when(orderRepository.findById(1L)).thenReturn(Optional.of(testOrder));

            assertThatThrownBy(() -> orderService.cancelOrder(1L))
                    .isInstanceOf(OrderExceptions.InvalidStatusTransitionException.class);
            verify(orderRepository, never()).save(any());
        }
    }

    @Nested
    @DisplayName("State Machine Tests")
    class StateMachineTests {
        @Test
        @DisplayName("Should allow PENDING -> CONFIRMED")
        void shouldAllowPendingToConfirmed() {
            assertThat(stateMachine.isValidTransition(OrderStatus.PENDING, OrderStatus.CONFIRMED)).isTrue();
        }

        @Test
        @DisplayName("Should reject DELIVERED -> PENDING")
        void shouldRejectDeliveredToPending() {
            assertThat(stateMachine.isValidTransition(OrderStatus.DELIVERED, OrderStatus.PENDING)).isFalse();
        }

        @Test
        @DisplayName("Should identify terminal states")
        void shouldIdentifyTerminalStates() {
            assertThat(stateMachine.isTerminalState(OrderStatus.DELIVERED)).isTrue();
            assertThat(stateMachine.isTerminalState(OrderStatus.CANCELLED)).isTrue();
            assertThat(stateMachine.isTerminalState(OrderStatus.PENDING)).isFalse();
        }
    }
}
