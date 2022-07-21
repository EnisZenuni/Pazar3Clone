package com.example.ecommercewebsite.Model;


import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Entity
@Table(name = "Pazar3_Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String email;
    String name;
    String lastName;
    String address;
    String username;
    String password;
    String phoneNumber;

    @OneToMany
    List<Product> productsList;

    public User(String email, String name, String lastName, String address, String username, String password, String phoneNumber, List<Product> productsList) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.productsList = productsList;
    }

    public User() {

    }
}
