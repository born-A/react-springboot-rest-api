package com.example.springbootbasicwalmart.controller.request;

import com.example.springbootbasicwalmart.utils.ItemType;

public record CreateItemRequest(ItemType itemType, int price, int quantity) {
}


