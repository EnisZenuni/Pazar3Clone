package com.example.ecommercewebsite.Model.Exceptions;

public class ShoppingCartNotFoundException extends RuntimeException {
    public ShoppingCartNotFoundException() {
        super("Shopping Cart Not Found");
    }
}
