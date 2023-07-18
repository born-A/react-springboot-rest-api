package com.example.springbootbasicwalmart.domain.item;

public abstract class Item {

    private Long id;
    private String name;
    private Long price;
    private Long amount;
    private boolean status;

    protected Item() {
    }
}
