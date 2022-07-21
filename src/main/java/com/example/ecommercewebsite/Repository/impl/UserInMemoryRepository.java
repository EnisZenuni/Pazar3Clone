package com.example.ecommercewebsite.Repository.impl;

import com.example.ecommercewebsite.DataHolder;
import com.example.ecommercewebsite.Model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserInMemoryRepository {
    public Optional<User> findByUserName(String username) {
        return DataHolder.users.stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }
    public Optional<User> findById(Integer Id) {
        return DataHolder.users.stream().filter(user -> user.getId().equals(Id)).findFirst();
    }
    public Optional<User> findByUserNameAndPassword(String username, String password) {

            return DataHolder.users.stream()
                    .filter(user -> user.getUsername()
                            .equals(username) && user.getPassword().equals(password))
                    .findFirst();

    }



    public User saveOrUpdate(User user) {
        DataHolder.users.removeIf(user1 -> user1.getUsername().equals(user.getUsername()));
        DataHolder.users.add(user);
        return user;
    }

    public void delete(String username) {
        DataHolder.users.removeIf(user -> user.getUsername().equals(username));
    }

}

