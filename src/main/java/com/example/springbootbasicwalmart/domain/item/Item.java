package com.example.springbootbasicwalmart.domain.item;

import com.example.springbootbasicwalmart.utils.ItemType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
public class Item {

    private Long id;
    private ItemType itemType;
    private Long price;
    private Long quantity;
}
