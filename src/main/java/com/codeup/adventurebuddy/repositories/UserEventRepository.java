package com.codeup.adventurebuddy.repositories;

import com.codeup.adventurebuddy.models.Event;
import com.codeup.adventurebuddy.models.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserEventRepository extends JpaRepository<UserEvent, Long> {
    List<UserEvent> findByUser(Long id);
    UserEvent findByEvent(Long id);
}
