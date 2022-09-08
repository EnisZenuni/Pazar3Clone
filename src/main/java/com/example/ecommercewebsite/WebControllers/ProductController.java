package com.example.ecommercewebsite.WebControllers;


import com.example.ecommercewebsite.Model.Category;
import com.example.ecommercewebsite.Model.Product;
import com.example.ecommercewebsite.Model.User;
import com.example.ecommercewebsite.Service.CategoryService;
import com.example.ecommercewebsite.Service.ProductService;
import com.example.ecommercewebsite.Service.ShoppingCartService;
import com.example.ecommercewebsite.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final UserService userService;
    private  final CategoryService categoryService;
    private  final ShoppingCartService shoppingCartService;

    public ProductController(ProductService productService, UserService userService, CategoryService categoryService, ShoppingCartService shoppingCartService) {
        this.productService = productService;
        this.userService = userService;
        this.categoryService = categoryService;
        this.shoppingCartService = shoppingCartService;
    }
    @GetMapping
    public String ProductsView(Model model) {
        List<Product> products = this.productService.findAll();
        model.addAttribute("products",products);
        return "products";

    }

    @GetMapping("/add-product")
    public String addProductView(Model model, HttpServletRequest request) {
        User user = (User) userService.loadUserByUsername(request.getRemoteUser());
        //if (user == null) return "redirect:/login";
        List<Category> categories = this.categoryService.findAll();
        String username = (String) request.getRemoteUser();
        model.addAttribute("username",username);
        model.addAttribute("user",user);
        model.addAttribute("categories",categories);

        return "add-product";
    }
    @PostMapping("/add-product")
    public String addProduct(@RequestParam String ProductName,@RequestParam Double ProductPrice,@RequestParam String ProductCity,
                             @RequestParam Integer ProductRating, @RequestParam String ProductDescription,
                             @RequestParam String ProductImage,@RequestParam Integer ProductCategory,HttpServletRequest request) {
        //productName,productCity,productPrice,productDescription,productImage,productRating,ProductQuantity,category
        //save(String productName,String productCity, Double productPrice,String productDescription, String productImage, Integer productRating, Integer ProductQuantity, Integer categoryId) {
        int productQuantity = 1;
        User user = (User) userService.loadUserByUsername(request.getRemoteUser());



        this.productService.save(ProductName,ProductCity,ProductPrice,ProductDescription,ProductImage,ProductRating,productQuantity,ProductCategory,request);
        return "redirect:/products";


    }



    //TODO qe mun remove the /city part veq leje /products?city=Kumanovo
    @GetMapping("/city")
    public String ProductByCityView(@RequestParam String city  ,Model model, HttpServletRequest request) {
        List<Product> filterByCity = this.productService.findAllByCity(city);
        model.addAttribute("products",filterByCity);
        return "products";
    }


    @GetMapping("/product-detail/{id}")
    public String ProductByCityView(@PathVariable Integer id  ,Model model, HttpServletRequest request) {
        Optional <Product> product = this.productService.findById(id);
        model.addAttribute("productDetail",product);
        return "productDetail";
    }

    @GetMapping("/myShop")
    public String ProductsByProfileView(Model model,HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");

        //if(user==null) return "login";
        String username = (String) request.getRemoteUser();
        List<Product> filterByUsername = this.productService.findAllByUsername(username);
        model.addAttribute("products",filterByUsername);
        model.addAttribute("username",username);
        model.addAttribute("user",user);
        return "shop";
      }



    @GetMapping("/category/{Id}")
    public String ProductsByCategoryView(@PathVariable Integer Id, Model model, HttpServletRequest request) {
        List<Product> filterByCategory = this.productService.findAllByCategory(Id);
        model.addAttribute("products",filterByCategory);
        return "products";
    }

    @GetMapping("/map/{city}")
    public String ProductsByMapCityView(@PathVariable String city,Model model) {
        List<Product> filterByCityMap = this.productService.findAllByCity(city);
        model.addAttribute("products",filterByCityMap);
        return "products";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id,HttpServletRequest request,Model model) {
        User user = (User) request.getSession().getAttribute("user");
        this.shoppingCartService.deleteProductFromShoppingCart(user.getUsername(),id);
        this.productService.deleteById(id);
        return "redirect:/myShop";
    }








}

