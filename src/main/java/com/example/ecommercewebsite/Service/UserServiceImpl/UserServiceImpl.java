package com.example.ecommercewebsite.Service.UserServiceImpl;

import com.example.ecommercewebsite.Model.User;
import com.example.ecommercewebsite.Repository.impl.UserInMemoryRepository;
import com.example.ecommercewebsite.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    private  final UserInMemoryRepository userInMemoryRepository;

    public UserServiceImpl(UserInMemoryRepository userInMemoryRepository) {
        this.userInMemoryRepository = userInMemoryRepository;
    }

    @Override
    public Optional<User> findByUserName(String username) {
        return this.userInMemoryRepository.findByUserName(username);
    }

    @Override
    public Optional<User> findById(Integer Id) {
        return this.userInMemoryRepository.findById(Id);
    }



}
