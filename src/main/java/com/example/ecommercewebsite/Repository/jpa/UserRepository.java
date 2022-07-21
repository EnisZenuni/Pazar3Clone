package com.example.ecommercewebsite.Repository.jpa;


import com.example.ecommercewebsite.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
Optional<User> findUserByUsernameAndPassword(String username,String password);
    Optional<User> findUserByUsername(String username);

}
