package com.codeup.adventurebuddy.controllers;


import com.codeup.adventurebuddy.models.Event;
import com.codeup.adventurebuddy.models.Trail;
import com.codeup.adventurebuddy.models.User;
//import com.codeup.adventurebuddy.models.UserEvents;
import com.codeup.adventurebuddy.models.UserEvent;
import com.codeup.adventurebuddy.repositories.EventRepository;
import com.codeup.adventurebuddy.repositories.TrailRepository;
import com.codeup.adventurebuddy.repositories.UserEventRepository;
import com.codeup.adventurebuddy.repositories.UserRepository;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.ConstraintDeclarationException;
import javax.validation.ConstraintViolationException;
import java.awt.*;
import java.util.ArrayList;

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
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userDao.getOne(user.getId());
        model.addAttribute("events", eventDao.findAll());
        return "events/index";
    }

    @GetMapping("/events/{id}")
    public String eventId(@PathVariable long id, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userDao.getOne(user.getId());
        Event event = eventDao.getOne(id);
        ArrayList<User> users = new ArrayList<>();
        int usersJoined = 0;
        int amountOfUsers = 0;
        for (UserEvent userEvent : event.getUserEvents() ) {
             users.add(userEvent.getUser());
             if(userEvent.getAccepted() == true)
                usersJoined++;
             else
                amountOfUsers++;
        }
        boolean joined = users.contains(currentUser);
        boolean canJoin = !users.contains(currentUser) && usersJoined < event.getRoomSize();
        model.addAttribute("canJoin", canJoin);
        model.addAttribute("joined", joined);
        model.addAttribute("usersJoined", usersJoined);
        model.addAttribute("amountOfUsers", amountOfUsers);
        model.addAttribute("event", event);
        model.addAttribute("user", user);
        event.setFull(usersJoined >= event.getRoomSize());
        eventDao.save(event);
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
                                @RequestParam String activity,
                                @RequestParam int roomSize) {
        Event eventToEdit = eventDao.getOne(id);
        eventToEdit.setTitle(title);
        eventToEdit.setDescription(description);
        eventToEdit.setDate(date);
        eventToEdit.setActivity(activity);
        eventToEdit.setRoomSize(roomSize);

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
        User user ;
        try { user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e ){
            e.printStackTrace();
            return "redirect:/login";
        }
        List<Event> events = eventDao.findByUser(user);
        model.addAttribute("myevents",events);
        return "daygrid-views";
    }


    @PostMapping("events/{id}/join")
    public String joinEvent(@PathVariable long id) {
        UserEvent userEvent = new UserEvent();
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userEvent.setUser(loggedInUser);
        userEvent.setEvent(eventDao.getOne(id));
        userEvent.setAccepted(false);
        try{
        userEventDao.save(userEvent);
        } catch (ConstraintViolationException e) {
//            System.out.println(e);
            return "redirect:/events/" + id;
        }
        return "redirect:/events/" + id;
    }

    @PostMapping("events/{id}/allow/{userEventId}")
    public String allowJoin(@PathVariable long id, @PathVariable long userEventId) {
        UserEvent ueToEdit = userEventDao.getOne(userEventId);
        ueToEdit.setAccepted(true);
        userEventDao.save(ueToEdit);
        return"redirect:/events/" + id;
    }

    @PostMapping("events/{id}/remove/{userEventId}")
    public String removeJoin(@PathVariable long id, @PathVariable long userEventId) {
        UserEvent ueToEdit = userEventDao.getOne(userEventId);
        ueToEdit.setAccepted(false);
        userEventDao.save(ueToEdit);
        return"redirect:/events/" + id;
    }
}
