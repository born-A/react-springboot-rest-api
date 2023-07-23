package com.example.springbootbasicwalmart.controller;

import com.example.springbootbasicwalmart.domain.order.Order;
import com.example.springbootbasicwalmart.controller.request.CreateOrderRequest;
import com.example.springbootbasicwalmart.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")

public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public Order order(@RequestBody CreateOrderRequest createOrderRequest) {
        Order order = orderService.order(createOrderRequest.customerId(),
                createOrderRequest.itemId(), createOrderRequest.count());
        return order;
    }

    @GetMapping
    public List<Order> showOrderList() {
        return orderService.getOrders();
    }
    @GetMapping("/{id}")
    public Order showOrderById(@PathVariable("id") Long id) {
        return orderService.getOrderById(id);
    }
    @PostMapping(value = "/cancel/{id}")
    public void cancelOrder(@PathVariable("id") Long id) {
        orderService.cancelOrder(id);
    }
}

