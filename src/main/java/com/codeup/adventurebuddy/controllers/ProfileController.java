package com.codeup.adventurebuddy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/profile/add")
    public String viewAddProfilePhoto(){
        return "addProfilePhoto";
    }
    @GetMapping("/profile")
    public String viewProfile(){
        return "Profile";
    }
}
