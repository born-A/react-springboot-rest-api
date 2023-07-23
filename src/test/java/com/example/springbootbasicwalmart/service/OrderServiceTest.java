package com.example.springbootbasicwalmart.service;

import com.example.springbootbasicwalmart.domain.customer.Customer;
import com.example.springbootbasicwalmart.domain.item.Item;
import com.example.springbootbasicwalmart.domain.order.Order;
import com.example.springbootbasicwalmart.repository.OrderRepository;
import com.example.springbootbasicwalmart.utils.ItemType;
import com.example.springbootbasicwalmart.utils.OrderStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    @Test
    public void 상품주문() {
        //Given
        Customer customer = new Customer();
        Item item = new Item(1111L, ItemType.valueOf("SNACK"), 1000, 100);
        int orderCount = 2;

        //When
        Order order = orderService.order(customer.getId(), item.getId(), orderCount);

        //Then
        assertEquals(OrderStatus.ORDER, order.getStatus());
        assertEquals( 1, order.getOrderItems().size());
        assertEquals( 8, item.getQuantity());
    }

    @Test
    public void 주문취소() {
        //Given
        Customer customer = new Customer();
        Item item = new Item(1111L, ItemType.valueOf("SNACK"), 1000, 100);
        int orderCount = 2;
        Order order = orderService.order(customer.getId(), item.getId(), orderCount);

        //When
        orderService.cancelOrder(order.getId());

        //Then
        Order getOrder = orderRepository.findById(order.getId()).get();
        assertEquals(OrderStatus.CANCEL, getOrder.getStatus());
        assertEquals( 10, item.getQuantity());
    }

}
