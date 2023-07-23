package com.example.springbootbasicwalmart.service;

import com.example.springbootbasicwalmart.domain.item.Item;
import com.example.springbootbasicwalmart.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    @Transactional
    public Item addNewItem(Item item) {
        Item savedItem = itemRepository.save(item);
        return savedItem;
    }
    public List<Item> getItems() {
        return itemRepository.findAll();
    }
    public Item getItemsById(Long itemId) {
        return itemRepository.findById(itemId).get();
    }

    public List<Item> getItemsByType(String ItemType) {
        return itemRepository.findByItemType(ItemType);
    }

    public void deleteById(Long itemId) {
        itemRepository.deleteById(itemId);
    }
}
