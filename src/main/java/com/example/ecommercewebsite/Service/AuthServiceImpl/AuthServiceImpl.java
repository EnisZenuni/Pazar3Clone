package com.example.ecommercewebsite.Service.AuthServiceImpl;


import com.example.ecommercewebsite.Model.Exceptions.InvalidArgumentsException;
import com.example.ecommercewebsite.Model.Exceptions.InvalidUserCredentialsException;
import com.example.ecommercewebsite.Model.Exceptions.UsernameAlreadyExistsException;
import com.example.ecommercewebsite.Model.User;
import com.example.ecommercewebsite.Repository.jpa.UserRepository;
import com.example.ecommercewebsite.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthServiceImpl implements AuthService {


    private final UserRepository userInMemoryRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userInMemoryRepository, PasswordEncoder passwordEncoder) {
        this.userInMemoryRepository = userInMemoryRepository;

        this.passwordEncoder = passwordEncoder;
    }


    // ==================> TODO encode o tu ta prish <==================== //
    @Override
    public User login(String username, String password) {
        if(username.isEmpty()|| password.isEmpty())
            throw new InvalidArgumentsException();

        return userInMemoryRepository.findUserByUsernameAndPassword(username,passwordEncoder.encode(password)).orElseThrow(InvalidUserCredentialsException::new);

    }

    @Override
    public User register(String name,String lastName,String username, String password, String repeatedPassword, String email, String Address,String phoneNumber) {
        if(username.isEmpty() || email.isEmpty() || password.isEmpty()  || repeatedPassword.isEmpty() || !password.equals(repeatedPassword))
            throw new InvalidArgumentsException();

        if(this.userInMemoryRepository.findUserByUsername(username).isPresent() ||
                !this.userInMemoryRepository.findUserByUsername(username).isEmpty())
            throw new UsernameAlreadyExistsException(username);

        User newUser = new User(email,name,lastName,Address,username,passwordEncoder.encode(password),phoneNumber,new ArrayList<>());
        return  userInMemoryRepository.save(newUser);
    }
}
