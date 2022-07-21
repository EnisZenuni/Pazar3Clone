package com.example.ecommercewebsite.Repository.jpa;


import com.example.ecommercewebsite.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByProductName(String name);
    void deleteProductByProductName(String name);
    List<Product> findAllByProductCity(String city);
    List<Product> findAllByCategory_CategoryId(Integer categoryId);
    List<Product> findProductsByUser_Username(String username);

}
