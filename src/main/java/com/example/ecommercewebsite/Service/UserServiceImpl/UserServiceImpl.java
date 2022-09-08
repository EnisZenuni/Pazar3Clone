package com.example.ecommercewebsite.Service.UserServiceImpl;

import com.example.ecommercewebsite.Model.Exceptions.InvalidArgumentsException;
import com.example.ecommercewebsite.Model.Exceptions.UsernameAlreadyExistsException;
import com.example.ecommercewebsite.Model.User;
import com.example.ecommercewebsite.Repository.jpa.UserRepository;
import com.example.ecommercewebsite.Service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User register(String name, String lastName, String username, String password, String repeatedPassword, String email, String Address, String phoneNumber) {
        if(username.isEmpty() || email.isEmpty() || password.isEmpty()  || repeatedPassword.isEmpty() || !password.equals(repeatedPassword))
            throw new InvalidArgumentsException();

        if(this.userRepository.findUserByUsername(username).isPresent() ||
                !this.userRepository.findUserByUsername(username).isEmpty())
            throw new UsernameAlreadyExistsException(username);

        User newUser = new User(email,name,lastName,Address,username,passwordEncoder.encode(password),phoneNumber,new ArrayList<>());
        return  userRepository.save(newUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));
    }
}
