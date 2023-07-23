package com.example.springbootbasicwalmart.service;

import com.example.springbootbasicwalmart.domain.customer.Customer;
import com.example.springbootbasicwalmart.domain.item.Item;
import com.example.springbootbasicwalmart.domain.order.Order;
import com.example.springbootbasicwalmart.domain.order.OrderItem;
import com.example.springbootbasicwalmart.repository.CustomerRepository;
import com.example.springbootbasicwalmart.repository.ItemRepository;
import com.example.springbootbasicwalmart.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public Long order(Long customerId, Long itemId, int count) {
        Customer customer = customerRepository.findById(customerId).get();
        Item item = itemRepository.findById(itemId).get();

        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
        Order order = Order.createOrder(customer, orderItem);

        orderRepository.save(order);
        return order.getId();
    }

    @Transactional
    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).get();
        order.cancel();
    }
}

