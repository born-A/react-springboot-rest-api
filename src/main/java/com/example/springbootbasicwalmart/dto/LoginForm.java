package com.example.springbootbasicwalmart.dto;


import lombok.Getter;
import lombok.Setter;


@Getter@Setter
public class LoginForm {
    private String email;
    private String password;
}