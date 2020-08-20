package com.codeup.adventurebuddy.controllers;

import com.codeup.adventurebuddy.repositories.EventRepository;
import com.codeup.adventurebuddy.repositories.TrailRepository;
import com.codeup.adventurebuddy.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ViewTrailsController {

    private final EventRepository eventsDao;
    private final TrailRepository trailsDao;
    private final UserRepository usersDao;

    public ViewTrailsController(EventRepository eventsDao, TrailRepository trailsDao, UserRepository usersDao) {
        this.eventsDao = eventsDao;
        this.trailsDao = trailsDao;
        this.usersDao = usersDao;
    }

    @GetMapping("/all-trails")
    public String viewAllTrails(Model model){
        model.addAttribute("allTrails", trailsDao.findAll());
        return "trails/all-trails";
    }
}
