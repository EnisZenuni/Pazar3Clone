package com.example.ecommercewebsite.WebControllers;

import com.example.ecommercewebsite.Model.Exceptions.InvalidArgumentsException;
import com.example.ecommercewebsite.Model.Exceptions.PasswordsDoNotMatchException;
import com.example.ecommercewebsite.Service.AuthService;
import com.example.ecommercewebsite.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private  final AuthService authService;
    private  final UserService userService;

    public RegisterController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @GetMapping
    public String ReturnRegisterView() {
        return "register";
    }

@PostMapping
public String Register(HttpServletRequest request,
                      Model model,
                      @RequestParam String name,
                      @RequestParam String lastname,
                      @RequestParam String address,
                      @RequestParam String email,
                      @RequestParam String username,
                      @RequestParam String password,
                      @RequestParam String repeatPassword,
                      @RequestParam String phoneNumber
) {

        try {
            this.authService.register(name,lastname,username,password,repeatPassword,email,address,phoneNumber);
            return "redirect:/login";
        } catch (InvalidArgumentsException | PasswordsDoNotMatchException exception) {
            return "redirect:/register?error=" + exception.getMessage();
        }

}

}
