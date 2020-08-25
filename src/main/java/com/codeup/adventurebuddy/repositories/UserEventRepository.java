package com.codeup.adventurebuddy.repositories;

import com.codeup.adventurebuddy.models.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEventRepository extends JpaRepository<UserEvent, Long> {

}
