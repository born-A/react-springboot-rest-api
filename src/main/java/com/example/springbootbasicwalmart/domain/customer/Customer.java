package com.example.springbootbasicwalmart.domain.customer;

import com.example.springbootbasicwalmart.domain.order.Order;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();
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
