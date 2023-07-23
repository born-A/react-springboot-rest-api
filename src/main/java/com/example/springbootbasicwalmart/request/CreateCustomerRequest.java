package com.example.springbootbasicwalmart.request;

public record CreateCustomerRequest(String email, String password, String name, String city, String street, String zipcode) {
}
