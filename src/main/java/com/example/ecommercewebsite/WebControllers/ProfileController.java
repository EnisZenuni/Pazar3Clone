package com.example.ecommercewebsite.WebControllers;


import com.example.ecommercewebsite.Model.User;
import com.example.ecommercewebsite.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    public final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showProfileView(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        return "profile";
    }

    @GetMapping("/editProfile")
    public String showEditProfileView(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        return "profileEdit";
    }

    @PostMapping("/editProfile")
    public String editProfile(HttpServletRequest request, Model model,
                             @RequestParam(required=false) String FirstName ,
                              @RequestParam(required=false) String LastName,
                              @RequestParam(required=false) String phoneNumber,
                              @RequestParam(required=false) String address) {
        User user = (User) request.getSession().getAttribute("user");

        // TODO MAYBE ADD A FUNCTION IN THE SERVICE
         int changedFlag = 0;
        if(!FirstName.isEmpty()&&!FirstName.isBlank()) {
            user.setName(FirstName);
            changedFlag++;
        }

        if(!LastName.isEmpty()&&!LastName.isBlank()) {
            user.setLastName(LastName);
            changedFlag++;
        }
        if(!phoneNumber.isEmpty()&&!phoneNumber.isBlank()) {
            user.setPhoneNumber(phoneNumber);
            changedFlag++;
        }

        if(!address.isEmpty()&&!address.isBlank()) {
            user.setAddress(address);
            changedFlag++;
        }
        
            return "redirect:/profile";

    }

}
