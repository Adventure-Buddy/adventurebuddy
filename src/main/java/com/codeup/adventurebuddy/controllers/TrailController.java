package com.codeup.adventurebuddy.controllers;

import com.codeup.adventurebuddy.services.TrailService;
import com.codeup.adventurebuddy.models.Trail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/trails")
public class TrailController {

    private TrailService trailService;

    public TrailController(TrailService trailService) {
        this.trailService = trailService;
    }

    @GetMapping("/list")
    public Iterable<Trail> list(){
        return trailService.list();
    }
}
