package com.codeup.adventurebuddy.controllers;

import com.codeup.adventurebuddy.Repositories.EmergencyContactsRepository;
import com.codeup.adventurebuddy.models.EmergencyContact;
import com.codeup.adventurebuddy.models.User;
import com.codeup.adventurebuddy.repositories.EventRepository;
import com.codeup.adventurebuddy.repositories.TrailRepository;
import com.codeup.adventurebuddy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfileController {
    private final com.codeup.adventurebuddy.repositories.UserRepository userDao;
    private final EmergencyContactsRepository emergencyContactsDao;
    private PasswordEncoder passwordEncoder;
    private final com.codeup.adventurebuddy.repositories.EventRepository eventDao;
    private final com.codeup.adventurebuddy.repositories.TrailRepository trailsDao;

    @Value("${fileStackKey}")
    private String fsKey;



    public ProfileController(UserRepository userDao, EmergencyContactsRepository emergencyContactsDao, EventRepository eventDao, TrailRepository trailsDao) {
        this.userDao = userDao;
        this.emergencyContactsDao = emergencyContactsDao;
        this.eventDao = eventDao;
        this.trailsDao = trailsDao;
    }

    @GetMapping("/profile")
    public String viewProfileTwo(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user",userDao.getOne(user.getId()));
        model.addAttribute("emergency",emergencyContactsDao.findAll());
//        model.addAttribute("events",user.getUserEvents());

        return "profile";
    }

//    Get and Post Mapping for handling photo upload
    @GetMapping("/profile/{id}/add")
    public String viewAddProfilePhoto(@PathVariable long id, Model model) {
        model.addAttribute("fsKey",fsKey);
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

//    Get and Post mapping for handling editing username / email / password

    @GetMapping("/profile/{id}/username")
    public String editUsername(@PathVariable long id, Model model){
        model.addAttribute("user", userDao.getOne(id));
        return "username-edit";
    }

    @PostMapping("/profile/{id}/username")
    public String insertEditUsername(@PathVariable long id, Model model, @RequestParam(name="username") String username,@RequestParam(name="email") String email,@RequestParam(name = "password") String password){
        model.addAttribute("user", userDao.getOne(id));
        User user = userDao.getOne(id);
        user.setUsername(username);
        user.setEmail(email);
        if(password.isEmpty()){
            user.setPassword(user.getPassword());
        }else{
        String hash = passwordEncoder.encode(password);
        user.setPassword(hash);
        }
        userDao.save(user);
        return "redirect:/profile";
    }

//    Get and Post for mapping the create an emergency contact page
    @GetMapping("/profile/{id}/emergencyCreate")
    public String insertEmergencyContact(@PathVariable long id, Model model){
        model.addAttribute("user", userDao.getOne(id));
        model.addAttribute("emergency", new EmergencyContact());
        return "emergency-contact-create";
    }

    @PostMapping("/profile/{id}/emergencyCreate")
    public String createEmergencyContact(@PathVariable long id, Model model,
                                         @RequestParam(name="email") String email, @RequestParam(name = "first") String first, @RequestParam(name = "last") String last,
                                         @RequestParam(name = "phone") String phone, @ModelAttribute EmergencyContact emergencyContact){
        emergencyContact.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        emergencyContact.setEmail(email);
        emergencyContact.setFirst_name(first);
        emergencyContact.setLast_name(last);
        emergencyContact.setPhone_number(phone);
        emergencyContactsDao.save(emergencyContact);
        return "redirect:/profile";
    }

//    Get and Post mapping for the edit emergency contact page
    @GetMapping("/profile/{id}/emergencyCont")
    public String editEmergencyContactShow(@PathVariable long id, Model model){
        model.addAttribute("emergency",emergencyContactsDao.getOne(id));
        return "emergency-edit";
    }

    @PostMapping("/profile/{id}/emergencyCont")
    public String editEmergencyContact(@PathVariable long id, @RequestParam(name="email") String email, @RequestParam(name = "first") String first, @RequestParam(name = "last") String last,
                                       @RequestParam(name = "phone") String phone, @ModelAttribute EmergencyContact emergencyContact){
        emergencyContact.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        emergencyContact.setEmail(email);
        emergencyContact.setFirst_name(first);
        emergencyContact.setLast_name(last);
        emergencyContact.setPhone_number(phone);
        emergencyContactsDao.save(emergencyContact);
        return "redirect:/profile";
    }
}
