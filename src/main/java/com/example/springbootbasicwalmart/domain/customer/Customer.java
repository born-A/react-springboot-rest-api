package com.example.springbootbasicwalmart.domain.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Customer {
    private final Long id;
    private String email;
    private String password;
    private String name;
    private Address address;
}
