package com.codeup.adventurebuddy.controllers;


import com.codeup.adventurebuddy.models.Event;
import com.codeup.adventurebuddy.models.Trail;
import com.codeup.adventurebuddy.models.User;
import com.codeup.adventurebuddy.repositories.EventRepository;
import com.codeup.adventurebuddy.repositories.TrailRepository;
import com.codeup.adventurebuddy.repositories.UserRepository;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EventController {

    private final EventRepository eventDao;
    private final UserRepository userDao;
    private final TrailRepository trailDao;

    public EventController(EventRepository eventDao, UserRepository userDao, TrailRepository trailDao) {
        this.eventDao = eventDao;
        this.userDao = userDao;
        this.trailDao = trailDao;
    }

    @GetMapping("/events")
    public String events(Model model) {
        model.addAttribute("events", eventDao.findAll());
        return "/events/index";
    }

    @GetMapping("/events/{id}")
    public String eventId(@PathVariable long id, Model model) {
        Event event = eventDao.getOne(id);
        model.addAttribute("event", event);
        return "/events/show";
    }

    @GetMapping("/events/create/{trailId}")
    public String getCreateEvent(@PathVariable long trailId, Model model) {
        Trail trail = trailDao.getOne(trailId);
        model.addAttribute("trail", trail);
        model.addAttribute("event", new Event());
        return "/events/create";
    }

    @PostMapping("/events/create/{trailId}")
    public String postCreateEvent(@PathVariable long trailId, @ModelAttribute Event event) {
//        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = userDao.getOne(1L);
        event.setUser(loggedInUser);
        event.setTrail(trailDao.getOne(trailId));
        eventDao.save(event);
        return "redirect:/events";
    }

    @GetMapping("events/{id}/edit")
    public String getEditEvent(@PathVariable long id, Model model) {
        model.addAttribute("event", eventDao.getOne(id));
        return "/events/edit";
    }

    @PostMapping("events/{id}/edit")
    public String postEditEvent(@PathVariable long id,
                                @RequestParam String title,
                                @RequestParam String description,
                                @RequestParam String date) {
        Event eventToEdit = eventDao.getOne(id);
        eventToEdit.setTitle(title);
        eventToEdit.setDescription(description);
        eventToEdit.setDate(date);

        eventDao.save(eventToEdit);

        return "redirect:/events/" + id;
    }
}
