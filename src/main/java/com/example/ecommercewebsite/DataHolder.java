package com.example.ecommercewebsite;

import com.example.ecommercewebsite.Model.Category;
import com.example.ecommercewebsite.Model.Product;
import com.example.ecommercewebsite.Model.ShoppingCart;
import com.example.ecommercewebsite.Model.User;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
@Getter
public class DataHolder {
    public static List<Product> products = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static List<Category> categories = new ArrayList<>();
    public static List<ShoppingCart> shoppingCarts = new ArrayList<>();



    /*
    @PostConstruct
    public void init() {
        Category cars = new Category(1,"Cars","Latest Cars");
        Category clothes = new Category(2,"Shoes","Best and Affordable Shoes");
        Category instruments = new Category(4,"Instruments","New Instruments");
        Category furniture = new Category(6,"Furniture","Furniture Description");
        Category electronics = new Category(3,"Electronics","Electronics Description");
        Category sports = new Category(5,"Sports","Sports Description");





        Product product1 = new Product("Vans Old Skool","Kumanovo",4500.0,"Vans with Premiuem Quality Brand new Lookin","https://scene7.zumiez.com/is/image/zumiez/product_main_medium/Vans-Old-Skool-Flame-Black-%26-White-Skate-Shoes-_279736-alt7-US.jpg",8,1,clothes);
        Product product2 = new Product("Guitar 4000","Kumanovo",12500.0,"Decent Voice,Strings are Brand new,Everything works fine","https://images.musicstore.de/images/1280/yamaha-c40-classical-guitar-_1_GIT0000636-000.jpg.webp",9,2,instruments);
        Product product3 = new Product("Opel Vectra","Kumanovo",50000.0 ,"10000km has AC no problems found,Highly tunnable", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/13/Opel_Vectra_C_2.2_Direkt_front.JPG/1200px-Opel_Vectra_C_2.2_Direkt_front.JPG",8,3,cars);
        Product product4 = new Product("Fiat Astra","Skopje",6500000.0,"Brand new looking","https://img.autoabc.lv/opel-astra/opel-astra_2004_Hecbeks_15102670957_2.jpg",1,8,cars);

        User user1 = new User("nisizenuni@gmail.com","Enis","Zenuni","Kumanovo 1300","Enis","enis","070951601",new ArrayList<>());
        User user2 = new User("rrezart@gmail.com","Rrezart","Saliu","Kumanovo 1300","Rrezart","rrezart","070123456",new ArrayList<>());


        users.add(user1); users.add(user2);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);

    } */
}
