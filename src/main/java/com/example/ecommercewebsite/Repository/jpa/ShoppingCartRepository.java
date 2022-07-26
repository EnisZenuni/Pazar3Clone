package com.example.ecommercewebsite.Repository.jpa;

import com.example.ecommercewebsite.Model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
    Optional<ShoppingCart> findShoppingCartByUser_Username(String username);
}
