package com.example.ecommercewebsite.Service.ShoppingCartServiceImpl;

import com.example.ecommercewebsite.Model.Exceptions.ProductAlreadyInShoppingCartException;
import com.example.ecommercewebsite.Model.Exceptions.ProductNotFoundException;
import com.example.ecommercewebsite.Model.Exceptions.ShoppingCartNotFoundException;
import com.example.ecommercewebsite.Model.Exceptions.UserNotFoundException;
import com.example.ecommercewebsite.Model.Product;
import com.example.ecommercewebsite.Model.ShoppingCart;
import com.example.ecommercewebsite.Model.User;
import com.example.ecommercewebsite.Repository.impl.ShoppingCartInMemoryRepository;
import com.example.ecommercewebsite.Repository.impl.UserInMemoryRepository;
import com.example.ecommercewebsite.Repository.jpa.ProductRepository;
import com.example.ecommercewebsite.Repository.jpa.ShoppingCartRepository;
import com.example.ecommercewebsite.Repository.jpa.UserRepository;
import com.example.ecommercewebsite.Service.ProductService;
import com.example.ecommercewebsite.Service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final UserRepository userInMemoryRepository;
    private final ShoppingCartRepository shoppingCartInMemoryRepository;
    private final ProductRepository productService;

    public ShoppingCartServiceImpl(UserRepository userInMemoryRepository, ShoppingCartRepository shoppingCartInMemoryRepository, ProductRepository productService) {
        this.userInMemoryRepository = userInMemoryRepository;
        this.shoppingCartInMemoryRepository = shoppingCartInMemoryRepository;
        this.productService = productService;
    }

    @Override
    public List<Product> listAllProductsInShoppingCart(Integer cartId) {
        return this.shoppingCartInMemoryRepository.findById(cartId).get().getProducts();
    }

    @Override
    public ShoppingCart getShoppingCart(String username) {
        return this.shoppingCartInMemoryRepository
                .findShoppingCartByUser_Username(username)
                .orElseGet(() -> {
                    User user = this.userInMemoryRepository.findUserByUsername(username)
                            .orElseThrow(() -> new UserNotFoundException(username));
                    ShoppingCart shoppingCart = new ShoppingCart(user);
                    return this.shoppingCartInMemoryRepository.save(shoppingCart);
                });

    }

    @Override
    public ShoppingCart addProductToShoppingCart(String username, Integer productId) {
        ShoppingCart shoppingCart = this.shoppingCartInMemoryRepository.findShoppingCartByUser_Username(username).orElseThrow(ShoppingCartNotFoundException::new);
        Product product = this.productService.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
        if(shoppingCart.getProducts()
                .stream().filter(i -> i.getProductId().equals(productId))
                .collect(Collectors.toList()).size() > 0)
            throw new ProductAlreadyInShoppingCartException(productId, username);
        shoppingCart.getProducts().add(product);
        return this.shoppingCartInMemoryRepository.save(shoppingCart);


    }

    @Override
    public ShoppingCart deleteProductFromShoppingCart(String username, Integer productId) {
        ShoppingCart shoppingCart = this.shoppingCartInMemoryRepository.findShoppingCartByUser_Username(username).orElseThrow(ShoppingCartNotFoundException::new);
        Product product = this.productService.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
        //shoppingCart.getProducts().stream().dropWhile(product1 -> product1.getProductId().equals(productId));
        shoppingCart.getProducts().removeIf(product1 -> product1.getProductId().equals(productId));
        return this.shoppingCartInMemoryRepository.save(shoppingCart);
    }


}
