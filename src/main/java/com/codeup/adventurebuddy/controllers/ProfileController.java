package com.codeup.adventurebuddy.controllers;

import com.codeup.adventurebuddy.models.User;
import com.codeup.adventurebuddy.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfileController {
    private final com.codeup.adventurebuddy.repositories.UserRepository userDao;

    public ProfileController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/profile")
    public String viewProfile(Model model) {
        model.addAttribute("user", (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "profile";
    }

    @GetMapping("/profile/{id}/add")
    public String viewAddProfilePhoto(@PathVariable long id, Model model) {
        model.addAttribute("user", userDao.getOne(id));
        return "addProfilePhoto";
    }

    @PostMapping("/profile/{id}/add")
    public String savePhoto(@RequestParam(name="profile_img") String img,@PathVariable long id){
        User user = userDao.getOne(id);
        user.setProfile_img(img);
        userDao.save(user);
        return "redirect:/profile";
    }
}
