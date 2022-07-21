package com.example.ecommercewebsite.Repository.impl;

import com.example.ecommercewebsite.DataHolder;
import com.example.ecommercewebsite.Model.Category;
import com.example.ecommercewebsite.Model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CategoryInMemoryRepository {
    public List<Category> findAll() {
        return DataHolder.categories;
    }
    public Optional<Category> findById(Integer id) {
        return DataHolder.categories.stream().filter(i -> i.getCategoryId().equals(id)).findFirst();
    }

    public List<Category> search(String text) {
        return DataHolder.categories
                .stream().filter(r->r.getCategoryName().contains(text) || r.getCategoryDescription()
                        .contains(text)).collect(Collectors.toList());
    }


}
