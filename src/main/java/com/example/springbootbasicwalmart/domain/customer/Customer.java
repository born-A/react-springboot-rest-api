package com.example.springbootbasicwalmart.domain.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;
    private String name;

    private String city;
    private String street;
    private String zipcode;

    public static Customer createCustomer(String email, String password, String name, String city,String street, String zipcode) {
        return getCustomer(email, password, name, city, street, zipcode);
    }

    private static Customer getCustomer(String email, String password, String name, String city, String street, String zipcode) {
        Customer customer = new Customer();
        customer.email = email;
        customer.password = password;
        customer.name = name;
        customer.city =city;
        customer.street=street;
        customer.zipcode=zipcode;
        return customer;
    }

    public Customer updateCustomer(String email, String password, String name, String city,String street, String zipcode){
        return getCustomer(email, password, name, city, street, zipcode);
    }

}
