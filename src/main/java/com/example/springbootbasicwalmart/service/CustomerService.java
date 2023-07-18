package com.example.springbootbasicwalmart.service;

import com.example.springbootbasicwalmart.domain.customer.Customer;
import com.example.springbootbasicwalmart.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }


    public Optional<Customer> getCustomerByName(String name) {
        return customerRepository.findByName(name);
    }

    public List<Customer> getCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        if (customerList.isEmpty()) {
            throw new RuntimeException("조회 결과가 없습니다");
        }
        return customerList;
    }


    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }


}
