package com.example.ecommercewebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class ECommerceWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceWebsiteApplication.class, args);
    }

}
