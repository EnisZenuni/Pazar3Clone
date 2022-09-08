package com.example.ecommercewebsite.WebControllers;


import com.example.ecommercewebsite.Model.Product;
import com.example.ecommercewebsite.Model.ShoppingCart;
import com.example.ecommercewebsite.Model.User;
import com.example.ecommercewebsite.Service.ProductService;
import com.example.ecommercewebsite.Service.ShoppingCartService;
import com.example.ecommercewebsite.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;
    private final UserService userService;

    public ShoppingCartController(ShoppingCartService shoppingCartService, ProductService productService, UserService userService) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping
    public String shoppingCartView(Model model, HttpServletRequest request) {


        /*TODO REMOEV THESE AND USE SEC AUTHORIZE IN THYMELEAF INSTEAD
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) return "login";
         */

        User user = (User) userService.loadUserByUsername(request.getRemoteUser());
        ShoppingCart shoppingCart = this.shoppingCartService.getShoppingCart(user.getUsername());
        List<Product> productList = shoppingCart.getProducts();
        Double total = productList.stream().map(Product::getProductPrice).mapToDouble(Double::doubleValue).sum();
        model.addAttribute("products", this.shoppingCartService.listAllProductsInShoppingCart(shoppingCart.getCartId()));
        model.addAttribute("total", total);


        return "shoppingCart";
    }

    @PostMapping("/add-product/{id}")
    public String addProductToShoppingCart(@PathVariable Integer id, HttpServletRequest request) {

        try{
            User user = (User) userService.loadUserByUsername(request.getRemoteUser());
            ShoppingCart shoppingCart = this.shoppingCartService.addProductToShoppingCart(user.getUsername(), id);
            return "redirect:/products";
        }catch (RuntimeException exception) {
            return "redirect:/shopping-cart?error=" + exception.getMessage();
        }
    }

    @PostMapping("/delete/{id}")
    public String removeProduct(@PathVariable Integer id,HttpServletRequest request) {
        User user = (User) userService.loadUserByUsername(request.getRemoteUser());
        this.shoppingCartService.deleteProductFromShoppingCart(user.getUsername(),id);
        return "redirect:/shopping-cart";
    }


    /*
    public String calculatePrice(@PathVariable Integer id) {
        List<Product> productList = this.shoppingCartService.listAllProductsInShoppingCart(id);
        Double sum = productList.stream().map(Product::getProductPrice).mapToDouble(Double::doubleValue).sum();

    }
     */



}
