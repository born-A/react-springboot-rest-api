package com.example.springbootbasicwalmart.request;

public record CreateOrderRequest(Long customerId, Long itemId, int count) {
}
