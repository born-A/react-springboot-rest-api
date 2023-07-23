package com.example.springbootbasicwalmart.controller;

import com.example.springbootbasicwalmart.domain.customer.Customer;
import com.example.springbootbasicwalmart.domain.item.Item;
import com.example.springbootbasicwalmart.domain.order.Order;
import com.example.springbootbasicwalmart.request.CreateOrderRequest;
import com.example.springbootbasicwalmart.service.CustomerService;
import com.example.springbootbasicwalmart.service.ItemService;
import com.example.springbootbasicwalmart.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final CustomerService customerService;
    private final ItemService itemService;

    @PostMapping()
    public Order order(@RequestBody CreateOrderRequest createOrderRequest) {
        return orderService.order(createOrderRequest.customerId(), createOrderRequest.itemId(), createOrderRequest.count());
    }
    @GetMapping
    public List<Order> showOrderList() {
        return orderService.getOrders();
    }
    @GetMapping("/{id}")
    public Order showOrderById(@PathVariable("id") Long id) {
        return orderService.getOrderById(id);
    }
    @PostMapping(value = "/orders/{orderId}/cancel")
    public void cancelOrder(@PathVariable("orderId") Long orderId) {
        orderService.cancelOrder(orderId);
    }
}

