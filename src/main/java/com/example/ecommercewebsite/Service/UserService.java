package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    User register(String name,String lastName,String username, String password, String repeatedPassword, String email, String Address,String phoneNumber);


}
