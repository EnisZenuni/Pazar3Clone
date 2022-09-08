package com.example.ecommercewebsite.WebControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/access-denied")
public class AccessController {

    @GetMapping
    public String accessDeniedView() {
        return "access-denied";
    }
}
