package com.example.springbootbasicwalmart.service;

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

    public Customer updateCustomer(Long id, String email, String password, String name, String city, String street, String zipcode) {
        Customer customer = customerRepository.findById(id).get();
        customer.setEmail(email);
        customer.setName(name);
        customer.setPassword(password);
        customer.setCity(city);
        customer.setStreet(street);
        customer.setZipcode(zipcode);
        customerRepository.save(customer);
        return customer;
    }


    @Transactional
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }


}
