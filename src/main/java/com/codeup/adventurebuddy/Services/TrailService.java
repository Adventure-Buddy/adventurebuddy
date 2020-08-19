package com.codeup.adventurebuddy.Services;

import com.codeup.adventurebuddy.Repositories.TrailRepository;
import com.codeup.adventurebuddy.models.Trail;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrailService {

    private TrailRepository trailRepository;

    public TrailService(TrailRepository trailRepository) {
        this.trailRepository = trailRepository;
    }

    public Iterable<Trail> list(){
        return trailRepository.findAll();
    }

    public Iterable<Trail> save(List<Trail> trails) {
        return trailRepository.saveAll(trails);
    }

}
