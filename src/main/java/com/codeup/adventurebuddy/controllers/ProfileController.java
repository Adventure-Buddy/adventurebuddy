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
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user",userDao.getOne(user.getId()));
        return "profile";
    }

//    Get and Post Mapping for handling photo upload
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

//    Get and Post mapping for handling basic edit
    @GetMapping("/profile/{id}/basic")
    public String editBasic(@PathVariable long id, Model model){
        model.addAttribute("user", userDao.getOne(id));
        return "basic-edit";
    }

    @PostMapping("/profile/{id}/basic")
    public String insertBasic(@PathVariable long id, Model model, @RequestParam(name="dob") String dob,@RequestParam(name="phone") String phone,@RequestParam(name = "first") String first,@RequestParam(name="last") String last){
        model.addAttribute("user", userDao.getOne(id));
        User user = userDao.getOne(id);
        user.setDateOfBirth(dob);
        user.setPhoneNumber(phone);
        user.setFirstName(first);
        user.setLastName(last);
        userDao.save(user);
        return "redirect:/profile";
    }
}
