package com.codeup.adventurebuddy.repositories;

import com.codeup.adventurebuddy.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByUser(Long id);
}
