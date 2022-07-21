package com.example.ecommercewebsite.Service;


import com.example.ecommercewebsite.Model.User;

import java.util.Optional;

public interface AuthService {
    User login(String username, String password);
    User register(String name,String lastName,String username, String password, String repeatedPassword, String email, String Address,String phoneNumber);
}

