package com.example.springbootbasicwalmart.controller.request;

public record CreateOrderRequest(Long customerId, Long itemId, int count) {
}
