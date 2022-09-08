package com.example.ecommercewebsite.Model;


import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer CartId;



    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    public User user;

    @ManyToMany
    public List<Product> products;

    public ShoppingCart() {
        this.CartId = (int)(Math.random()*100);
    }

    public ShoppingCart(User user) {
        this.CartId = (int)(Math.random()*100);
        this.products = new ArrayList<>();
        this.user = user;
    }


}
