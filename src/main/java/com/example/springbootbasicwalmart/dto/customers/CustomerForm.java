package com.example.springbootbasicwalmart.dto.customers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerForm {

    private String email;
    private String password;
    private String name;

    private String city;
    private String street;
    private String zipcode;

    public static CustomerForm createCustomerForm(String email, String password, String name, String city, String street, String zipcode) {
        CustomerForm customerForm = new CustomerForm();
        customerForm.email = email;
        customerForm.password = password;
        customerForm.name = name;
        customerForm.city = city;
        customerForm.street = street;
        customerForm.zipcode = zipcode;
        return customerForm;
    }
}
