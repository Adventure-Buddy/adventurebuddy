package com.codeup.adventurebuddy.repositories;

import com.codeup.adventurebuddy.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
