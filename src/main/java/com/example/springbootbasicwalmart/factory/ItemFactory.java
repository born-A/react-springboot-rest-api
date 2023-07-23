package com.example.springbootbasicwalmart.factory;

import com.example.springbootbasicwalmart.domain.item.Item;
import com.example.springbootbasicwalmart.utils.ItemType;

import java.util.Random;

public class ItemFactory {
    public static Item createItem(ItemType type, long price, long quantity) {

        return new Item(new Random().nextLong() > 0 ? new Random().nextLong() : (new Random().nextLong()) * (-1), type,price, quantity);
    }
}
