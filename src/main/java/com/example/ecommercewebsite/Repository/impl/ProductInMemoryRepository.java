package com.example.ecommercewebsite.Repository.impl;


import com.example.ecommercewebsite.DataHolder;
import com.example.ecommercewebsite.Model.Category;
import com.example.ecommercewebsite.Model.Product;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/*
@Repository
public class ProductInMemoryRepository {



    public List<Product> findAll() {
        return DataHolder.products;

    }
    public Optional<Product> findById(Integer id) {
        return DataHolder.products.stream().filter(i -> i.getProductId().equals(id)).findFirst();
    }

    public Optional<Product> findByName(String name) {
        return  DataHolder.products.stream().filter(i->i.getProductName().equalsIgnoreCase(name)).findFirst();
    }

    public List<Product> findAllByCity(String city) {
        return DataHolder.products.stream().filter(product -> product.getProductCity().equalsIgnoreCase(city)).collect(Collectors.toList());
    }


    //TODO kshyr se nashta me model duhet
    public List<Product> findAllByCategory(Integer Id) {
        return DataHolder.products.stream().filter(product -> product.getCategory().getCategoryId().equals(Id)).collect(Collectors.toList());
    }




    public Optional<Product> save( String productName,String productCity, Double productPrice,String productDescription, String productImage, Integer productRating,Integer ProductQuantity,Category category) {
        DataHolder.products.removeIf(i -> i.getProductName().equals(productName));
        Product product = new Product(productName,productCity,productPrice,productDescription,productImage,productRating,ProductQuantity,category);
        DataHolder.products.add(product);
        return Optional.of(product);
    }
    public void deleteById(Integer id) {
        DataHolder.products.removeIf(i -> i.getProductId().equals(id));
    }

    public Optional<Product> AddProduct( String productName,String productCity, Double productPrice,String productDescription, String productImage, Integer productRating,Integer ProductQuantity,Category category) {
        Product product = new Product(productName,productCity,productPrice,productDescription,productImage,productRating,ProductQuantity,category);
        DataHolder.products.add(product);
        return Optional.of(product);
    }





}

 */
