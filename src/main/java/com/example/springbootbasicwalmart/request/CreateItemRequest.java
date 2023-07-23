package com.example.springbootbasicwalmart.request;

import com.example.springbootbasicwalmart.utils.ItemType;

public record CreateItemRequest(ItemType itemType, long price, long quantity) {
}
