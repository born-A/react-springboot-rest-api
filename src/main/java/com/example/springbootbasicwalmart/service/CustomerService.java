package com.example.springbootbasicwalmart.service;

import com.example.springbootbasicwalmart.domain.customer.Address;
import com.example.springbootbasicwalmart.domain.customer.Customer;
import com.example.springbootbasicwalmart.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
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

    public void updateCustomer(Long id, String email, String password, String name, String city, String street, String zipcode) {
        Optional<Customer> findCustomer = customerRepository.findById(id);
        Customer customer = findCustomer.get();
        Address address = new Address(city, street, zipcode);
        customer.updateCustomer(email, password, name, address);
    }

    @Transactional
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }


}
