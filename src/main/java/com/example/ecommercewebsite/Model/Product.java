package com.example.ecommercewebsite.Model;

import lombok.Data;
import lombok.Generated;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer productId;

    public String productName;
    public String productCity;
    public Double productPrice;
    public String productDescription;
    public String productImage;
    public Integer productRating;
    public Integer productQuantity;

    @ManyToOne
    public Category category;

    @ManyToOne
    public User user;


    public Product(String productName, String productCity, Double productPrice, String productDescription, String productImage, Integer productRating, Integer productQuantity, Category category,User user) {
        this.productName = productName;
        this.productCity = productCity;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.productRating = productRating;
        this.productQuantity = productQuantity;
        this.category = category;
        this.user = user;
    }

    public Product() {

    }
}
