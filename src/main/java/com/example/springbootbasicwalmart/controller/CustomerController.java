package com.example.springbootbasicwalmart.controller;

import com.example.springbootbasicwalmart.domain.customer.Customer;
import com.example.springbootbasicwalmart.controller.request.CreateCustomerRequest;
import com.example.springbootbasicwalmart.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer addNewCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        Customer customer = Customer.createCustomer(createCustomerRequest.email(),
                createCustomerRequest.password(), createCustomerRequest.name(),
                createCustomerRequest.city(),createCustomerRequest.street(),createCustomerRequest.zipcode());
        Customer addNewCustomer = customerService.addNewCustomer(customer);
        return addNewCustomer;
    }

    @GetMapping
    public List<Customer> showCustomerList() {
        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public Customer showCustomerById(@PathVariable("id") Long id) {
        return customerService.getCustomerById(id).get();
    }

    @PostMapping("/update/{id}")
    public Customer updateCustomer(@PathVariable("id") Long id,
                                   @RequestBody CreateCustomerRequest createCustomerRequest) {
        return customerService.updateCustomer(id, createCustomerRequest.email(), createCustomerRequest.password(),
                createCustomerRequest.name(), createCustomerRequest.city(), createCustomerRequest.street(),
                createCustomerRequest.zipcode());
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomerById(id);
    }

}
