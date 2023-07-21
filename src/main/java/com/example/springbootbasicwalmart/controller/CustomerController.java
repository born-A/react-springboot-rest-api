package com.example.springbootbasicwalmart.controller;

import com.example.springbootbasicwalmart.domain.customer.Address;
import com.example.springbootbasicwalmart.domain.customer.Customer;
import com.example.springbootbasicwalmart.dto.customers.CustomerForm;
import com.example.springbootbasicwalmart.service.CustomerService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")

public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/new")
    public String showAddCustomer(Model model) {
        CustomerForm customerForm = new CustomerForm();
        model.addAttribute("customerForm", customerForm);
        return "customers/customer-new";
    }

    @PostMapping("/new")
    public String addCustomer(CustomerForm customerForm) {
        String email =customerForm.getEmail();
        String password = customerForm.getPassword();
        String name = customerForm.getName();

        String city = customerForm.getCity();
        String street = customerForm.getStreet();
        String zipcode = customerForm.getZipcode();

        Customer newCustomer = Customer.createCustomer(email, password, name, city,street,zipcode);
        customerService.addNewCustomer(newCustomer);
        return "redirect:/";
    }

    @GetMapping
    public String showCustomerList(Model model) {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "customers/customer-list";
    }

    @GetMapping("/{id}")
    public String showCustomerDetail(@PathVariable("id") Long id, Model model) {
        Optional<Customer> findCustomer = customerService.getCustomerById(id);
        CustomerForm customerForm = new CustomerForm();
        model.addAttribute("customer", findCustomer);
        model.addAttribute("customerForm", customerForm);
        return "customers/customer-detail";
    }
    @GetMapping("/update/{id}")
    public String showUpdateCustomer(@PathVariable("id") Long id,Model model) {
        Customer findCustomer = customerService.getCustomerById(id).get();
        model.addAttribute("customer", findCustomer);
        return "customers/customer-update";
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable("id") Long id,@ModelAttribute CustomerForm customerForm) {
        customerService.updateCustomer(id,customerForm.getEmail(), customerForm.getPassword(),customerForm.getName(), customerForm.getCity(), customerForm.getStreet(), customerForm.getZipcode());
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam Long id){
        customerService.deleteCustomerById(id);
        return "redirect:/";
    }

}
