package com.example.springbootbasicwalmart.dto.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemForm {
    private Long id;
    private String name;
    private Long price;
    private Long stockQuantity;
}
