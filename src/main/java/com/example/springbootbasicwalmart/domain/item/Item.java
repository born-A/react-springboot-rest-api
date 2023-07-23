package com.example.springbootbasicwalmart.domain.item;

import com.example.springbootbasicwalmart.domain.order.OrderItem;
import com.example.springbootbasicwalmart.utils.ItemType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue
    private Long id;
    private ItemType itemType;
    private int price;
    private int quantity;

    @JsonIgnore
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    public Item(Long id, ItemType itemType, int price, int quantity) {
        this.id = id;
        this.itemType = itemType;
        this.price = price;
        this.quantity =quantity;
    }


    public static Item createItem(ItemType itemType, int price, int quantity) {
        return new Item(new Random().nextLong() > 0 ?  new Random().nextLong() : (new Random().nextLong()) * (-1),itemType, price,quantity);
    }


    public void addStock(int quantity) {
        this.quantity += quantity;
    }

    public void removeStock(int quantity) {
        int remainStock = this.quantity - quantity;
        if (remainStock < 0) {
            throw new RuntimeException("need more stock");
        }
        this.quantity = remainStock;
    }
}
