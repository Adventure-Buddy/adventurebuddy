package com.codeup.adventurebuddy.controllers;


import com.codeup.adventurebuddy.models.Event;
import com.codeup.adventurebuddy.models.User;
import com.codeup.adventurebuddy.repositories.EventRepository;
import com.codeup.adventurebuddy.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EventController {

    private final EventRepository eventDao;
    private final UserRepository userDao;

    public EventController(EventRepository eventDao, UserRepository userDao) {
        this.eventDao = eventDao;
        this.userDao = userDao;
    }

    @GetMapping("/events")
    public String events(Model model) {
        model.addAttribute("events", eventDao.findAll());
        return "/events/index";
    }

    @GetMapping("/events/{id}")
    @ResponseBody
    public String eventId(@PathVariable long id) {
        return "This is the event #" + id;
    }

    @GetMapping("/events/create/{trailId}")
    public String getCreateEvent(@PathVariable long trailId, Model model) {
        model.addAttribute("event", new Event());
        return "/events/create";
    }

    @PostMapping("/events/create/{trailId}")
    public String postCreateEvent(@PathVariable long trailId, @ModelAttribute Event event) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        event.setUser(loggedInUser);
        eventDao.save(event);
        return "redirect:/events";
    }
}
