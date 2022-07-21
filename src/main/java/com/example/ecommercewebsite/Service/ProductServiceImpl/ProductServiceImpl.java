package com.example.ecommercewebsite.Service.ProductServiceImpl;


import com.example.ecommercewebsite.Model.Category;
import com.example.ecommercewebsite.Model.Exceptions.CategoryNotFoundException;
import com.example.ecommercewebsite.Model.Product;
import com.example.ecommercewebsite.Model.User;
import com.example.ecommercewebsite.Repository.jpa.CategoryRepository;
import com.example.ecommercewebsite.Repository.jpa.ProductRepository;
import com.example.ecommercewebsite.Service.ProductService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productInMemoryRepository;
    private final CategoryRepository categoryInMemoryRepository;

    public ProductServiceImpl(ProductRepository productInMemoryRepository, CategoryRepository categoryInMemoryRepository) {
        this.productInMemoryRepository = productInMemoryRepository;
        this.categoryInMemoryRepository = categoryInMemoryRepository;
    }


    @Override
    public List<Product> findAll() {
        return  this.productInMemoryRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return this.productInMemoryRepository.findById(id);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return this.productInMemoryRepository.findByProductName(name);
    }


    @Override
    @Transactional
    public Optional<Product> save(String productName, String productCity, Double productPrice, String productDescription, String productImage, Integer productRating, Integer ProductQuantity, Integer categoryId, HttpServletRequest request) {
        Category category = this.categoryInMemoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException(categoryId));
        this.productInMemoryRepository.deleteProductByProductName(productName);
        User user = (User) request.getSession().getAttribute("user");
        return Optional.of(this.productInMemoryRepository.save(new Product(productName,productCity,productPrice,productDescription,productImage,productRating,ProductQuantity,category,user)));
    }

    @Override
    public List<Product> findAllByCity(String cityName) {
        return  this.productInMemoryRepository.findAllByProductCity(cityName);
    }

    @Override
    public List<Product> findAllByCategory(Integer categoryId) {
        //Optional<Category> selectedCategory = this.categoryInMemoryRepository.findById(categoryId);
        return this.productInMemoryRepository.findAllByCategory_CategoryId(categoryId);
    }

    @Override
    public List<Product> findAllByUsername(String username) {
        return this.productInMemoryRepository.findProductsByUser_Username(username);
    }

    @Override
    public void deleteById(Integer id) {
     this.productInMemoryRepository.deleteById(id);
    }
}
