package com.example.ecommercewebsite.WebControllers;

import com.example.ecommercewebsite.Model.Exceptions.InvalidUserCredentialsException;
import com.example.ecommercewebsite.Model.User;
import com.example.ecommercewebsite.Service.AuthService;
import com.example.ecommercewebsite.Service.AuthServiceImpl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
@RequestMapping("/login")
public class LoginController {

    private final AuthServiceImpl authService;

    public LoginController(AuthServiceImpl authService) {
        this.authService = authService;
    }


    @GetMapping
    public String LogInView() {
        return "login";
    }


    @PostMapping
    public String login(HttpServletRequest request, Model model) {
        User user = null;
        try{
            user = this.authService.login(request.getParameter("username"),
                    request.getParameter("password"));
            request.getSession().setAttribute("user", user);
            return "redirect:/home";
        }
        catch (InvalidUserCredentialsException exception) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "login";
        }
    }


}
