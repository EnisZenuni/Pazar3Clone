package com.example.ecommercewebsite.Service;


import com.example.ecommercewebsite.Model.Category;
import com.example.ecommercewebsite.Model.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Integer id);
    Optional<Product> findByName(String name);
    Optional<Product> save(String productName, String productCity, Double productPrice, String productDescription, String productImage, Integer productRating, Integer ProductQuantity, Integer categoryId, HttpServletRequest request);
    List<Product> findAllByCity(String cityName);
    List<Product> findAllByCategory(Integer categoryId);
    List<Product> findAllByUsername(String username);
    void deleteById(Integer id);
}
