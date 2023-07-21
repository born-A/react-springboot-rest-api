package com.example.springbootbasicwalmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    @RequestMapping("/")
    public String homeLogin(){
        return "home";
    }
}
