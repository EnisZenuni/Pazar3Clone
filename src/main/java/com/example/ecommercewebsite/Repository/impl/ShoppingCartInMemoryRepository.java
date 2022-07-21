package com.example.ecommercewebsite.Repository.impl;


import com.example.ecommercewebsite.DataHolder;
import com.example.ecommercewebsite.Model.ShoppingCart;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ShoppingCartInMemoryRepository {
    public Optional<ShoppingCart> findById(Integer id) {
        return DataHolder.shoppingCarts.stream().filter(i -> i.getCartId().equals(id)).findFirst();
    }

    public Optional<ShoppingCart> findByUsername(String username) {
        return DataHolder.shoppingCarts.stream()
                .filter(i -> i.getUser().getUsername().equals(username))
                .findFirst();
    }
    public ShoppingCart save(ShoppingCart shoppingCart) {
        DataHolder.shoppingCarts
                .removeIf(i -> i.getUser().getUsername().equals(shoppingCart.getUser().getUsername()));
        DataHolder.shoppingCarts.add(shoppingCart);
        return shoppingCart;
    }




}
