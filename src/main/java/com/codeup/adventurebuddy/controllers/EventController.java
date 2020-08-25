package com.codeup.adventurebuddy.controllers;


import com.codeup.adventurebuddy.models.Event;
import com.codeup.adventurebuddy.models.Trail;
import com.codeup.adventurebuddy.models.User;
//import com.codeup.adventurebuddy.models.UserEvents;
import com.codeup.adventurebuddy.repositories.EventRepository;
import com.codeup.adventurebuddy.repositories.TrailRepository;
import com.codeup.adventurebuddy.repositories.UserEventRepository;
import com.codeup.adventurebuddy.repositories.UserRepository;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.awt.*;

@Controller
public class EventController {

    private final EventRepository eventDao;
    private final UserRepository userDao;
    private final TrailRepository trailDao;
    private final UserEventRepository userEventDao;

    public EventController(EventRepository eventDao, UserRepository userDao, TrailRepository trailDao, UserEventRepository userEventDao) {
        this.eventDao = eventDao;
        this.userDao = userDao;
        this.trailDao = trailDao;
        this.userEventDao = userEventDao;
    }

    @GetMapping("/events")
    public String events(Model model) {
        model.addAttribute("events", eventDao.findAll());
        return "events/index";
    }

    @GetMapping("/events/{id}")
    public String eventId(@PathVariable long id, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Event event = eventDao.getOne(id);
        model.addAttribute("event", event);
        model.addAttribute("user", user);
        return "events/show";
    }

    @GetMapping("/events/create/{trailId}")
    public String getCreateEvent(@PathVariable long trailId, Model model) {
        Trail trail = trailDao.getOne(trailId);
        model.addAttribute("trail", trail);
        model.addAttribute("event", new Event());

        return "events/create";
    }

    @PostMapping("/events/create/{trailId}")
    public String postCreateEvent(@PathVariable long trailId, @ModelAttribute Event event) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User loggedInUser = userDao.getOne(1L);
        event.setUser(loggedInUser);
        event.setTrail(trailDao.getOne(trailId));
        eventDao.save(event);
        return "redirect:/events";
    }

    @GetMapping("events/{id}/edit")
    public String getEditEvent(@PathVariable long id, Model model) {
        model.addAttribute("event", eventDao.getOne(id));
        return "events/edit";
    }

    @PostMapping("events/{id}/edit")
    public String postEditEvent(@PathVariable long id,
                                @RequestParam String title,
                                @RequestParam String description,
                                @RequestParam String date,
                                @RequestParam String activity) {
        Event eventToEdit = eventDao.getOne(id);
        eventToEdit.setTitle(title);
        eventToEdit.setDescription(description);
        eventToEdit.setDate(date);
        eventToEdit.setActivity(activity);

        eventDao.save(eventToEdit);

        return "redirect:/events/" + id;
    }

    @PostMapping("events/{id}/delete")
    public String deleteEvent(@PathVariable long id) {
        eventDao.deleteById(id);
        return "redirect:/events";
    }

    @GetMapping("/event/events-calendar")
    public String viewAllEventsJson(Model model){
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Event event = eventDao.getOne(1L);
//        List<Event> events = eventDao.findByUser(user.getId());
//        for (int i=0; i < events.size();i++){
//            String date = events.get(i).getDate();
//            date = date.replace(" ", "D");
//            events.get(i).setDate(date);
//        }
        model.addAttribute("myevents",event.getTitle());
        return "daygrid-views";
    }

//    @GetMapping("/events/userevents")
//    public @ResponseBody List<Event> viewEventUserEvents(){
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        List<UserEvents> userEvents = userEventDao.findAll();
//        List<Event> events = new ArrayList<>();
//
//        for (int i=0; i < userEvents.size(); i++){
//            if (userEvents.get(i).getUser().getId() == user.getId()){
//                events.add(userEvents.get(i).getEvent());
//            }
//        }
//        return "";
//    }

    @PostMapping("events/{id}/join")
    public String joinEvent(@PathVariable long id) {

    return "redirect:/events" + id;
    }
}
