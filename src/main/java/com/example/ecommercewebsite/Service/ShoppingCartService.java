package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.Product;
import com.example.ecommercewebsite.Model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    List<Product> listAllProductsInShoppingCart(Integer cartId);
    ShoppingCart getShoppingCart(String username);
    ShoppingCart addProductToShoppingCart(String username, Integer productId);
    ShoppingCart  deleteProductFromShoppingCart(String username,Integer productId);

}
