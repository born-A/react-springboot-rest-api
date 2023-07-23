package com.example.springbootbasicwalmart.controller;

import com.example.springbootbasicwalmart.domain.item.Item;
import com.example.springbootbasicwalmart.controller.request.CreateItemRequest;
import com.example.springbootbasicwalmart.service.ItemService;
import com.example.springbootbasicwalmart.utils.ItemType;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("item-types")
    public List<ItemType> itemTypes() {
        return List.of(ItemType.values());
    }

    @PostMapping
    public Item addNewItem(@RequestBody CreateItemRequest createItemRequest) {
        Item item = Item.createItem(createItemRequest.itemType(), createItemRequest.price(),
                createItemRequest.quantity());
        Item newItem = itemService.addNewItem(item);
        return newItem;
    }

    @GetMapping
    public List<Item> showItemList() {
        return itemService.getItems();
    }

    @GetMapping("/{item-type}")
    public List<Item> findByItemType(@PathVariable("item-type") String itemType) {
        List<Item> itemsByType = itemService.getItemsByType(itemType);
        return itemsByType;
    }

    @GetMapping("/view/{item-id}")
    public Item viewItem(@PathVariable("item-id") Long itemId) {
        return itemService.getItemsById(itemId);
    }


    @DeleteMapping("/delete/{item-id}")
    public void deleteItem( @PathVariable("item-id") Long itemId) {
        itemService.deleteById(itemId);
    }
}