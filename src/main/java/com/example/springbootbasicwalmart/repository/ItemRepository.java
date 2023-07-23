package com.example.springbootbasicwalmart.repository;

import com.example.springbootbasicwalmart.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    List<Item> findByType(String itemType);
}
