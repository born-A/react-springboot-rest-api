package com.example.springbootbasicwalmart.domain.customer;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;
    private String name;

    @Embedded
    private Address address;

    public Customer() {
    }

    public static Customer createCustomer(String email, String password, String name, Address address) {
        Customer customer = new Customer();
        customer.email = email;
        customer.password = password;
        customer.name = name;
        customer.address = address;
        return customer;
    }

    public Customer updateCustomer(String email, String password, String name, Address address){
        Customer customer = new Customer();
        customer.email = email;
        customer.password = password;
        customer.name = name;
        customer.address = address;
        return customer;
    }

}
