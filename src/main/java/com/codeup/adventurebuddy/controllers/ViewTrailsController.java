package com.codeup.adventurebuddy.controllers;

import com.codeup.adventurebuddy.models.Review;
import com.codeup.adventurebuddy.models.Trail;
import com.codeup.adventurebuddy.models.User;
import com.codeup.adventurebuddy.repositories.EventRepository;
import com.codeup.adventurebuddy.repositories.ReviewRepository;
import com.codeup.adventurebuddy.repositories.TrailRepository;
import com.codeup.adventurebuddy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Controller
public class ViewTrailsController {

    private final EventRepository eventsDao;
    private final TrailRepository trailsDao;
    private final UserRepository usersDao;
    private final ReviewRepository reviewsDao;
    @Value("${MAPBOX_KEY}")
    private String mbKey;

    public ViewTrailsController(EventRepository eventsDao, TrailRepository trailsDao, UserRepository usersDao, ReviewRepository reviewsDao) {
        this.eventsDao = eventsDao;
        this.trailsDao = trailsDao;
        this.usersDao = usersDao;
        this.reviewsDao = reviewsDao;
    }

    @GetMapping("/trails")
    public String viewAllTrails(Model model){
        model.addAttribute("allTrails", trailsDao.findAll());
        return "trails/all-trails";
    }

    @GetMapping("/trails/{id}")
    public String trailDetails(@PathVariable long id, Model model){
        model.addAttribute("mbKey",mbKey);
        model.addAttribute("singleTrail", trailsDao.getOne(id));
        return "trails/show";
    }

    @GetMapping("/trails/{id}/review")
    public String reviewTrail(@PathVariable long id, Model model){
        Trail trail = trailsDao.getOne(id);
        model.addAttribute("trail", trail);
        model.addAttribute("review", new Review());
        return "trails/review-trail";
    }

    @PostMapping("/trails")
    public String addReview(@RequestParam(value="trailId") long trailId, @ModelAttribute Review review){
        //get current date and time of review.
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Trail trail = trailsDao.getOne(trailId);
        review.setCreatedAt(dtf.format(now));
        review.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        review.setTrail(trail);

        trail.getReviewsList().add(review);
        reviewsDao.save(review);
        return "redirect:/trails";
    }


}
