package com.example.springbootbasicwalmart.controller;

import com.example.springbootbasicwalmart.domain.customer.Customer;
import com.example.springbootbasicwalmart.domain.item.Item;
import com.example.springbootbasicwalmart.service.CustomerService;
import com.example.springbootbasicwalmart.service.ItemService;
import com.example.springbootbasicwalmart.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final CustomerService customerService;
    private final ItemService itemService;

    @GetMapping(value = "/order")
    public String createForm(Model model) {
        List<Customer> members = customerService.getCustomers();
        List<Item> items = itemService.getItems();
        model.addAttribute("cusrs", members);
        model.addAttribute("items", items);
        return "order/orderForm";
    }
    @PostMapping(value = "/order")
    public String order(@RequestParam("memberId") Long memberId,
                        @RequestParam("itemId") Long itemId, @RequestParam("count") int count) {
        orderService.order(memberId, itemId, count);
        return "redirect:/orders";
    }

    @PostMapping(value = "/orders/{orderId}/cancel")
    public String cancelOrder(@PathVariable("orderId") Long orderId) {
        orderService.cancelOrder(orderId);
        return "redirect:/orders";
    }
}

