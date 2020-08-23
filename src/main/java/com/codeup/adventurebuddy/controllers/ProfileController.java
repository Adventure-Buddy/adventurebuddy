package com.codeup.adventurebuddy.controllers;

import com.codeup.adventurebuddy.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {

    @GetMapping("/profile/add")
    public String viewAddProfilePhoto(){
        return "addProfilePhoto";
    }
    @GetMapping("/profile{username}")
    public String viewProfile(@PathVariable String username, Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        username = user.getUsername();
        model.addAttribute("user", username);
        return "profile";
    }
}
