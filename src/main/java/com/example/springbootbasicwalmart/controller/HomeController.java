package com.example.springbootbasicwalmart.controller;

import com.example.springbootbasicwalmart.domain.customer.Customer;
import com.example.springbootbasicwalmart.dto.LoginForm;
import com.example.springbootbasicwalmart.session.SessionConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String homeLogin(){
        return "home";
    }
}
