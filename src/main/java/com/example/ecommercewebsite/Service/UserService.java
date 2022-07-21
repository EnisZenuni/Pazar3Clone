package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUserName(String username);
    Optional<User> findById(Integer Id);

}
