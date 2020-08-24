package com.codeup.adventurebuddy.controllers;

import com.codeup.adventurebuddy.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String showLoginForm(){return "Users/login";}
}
