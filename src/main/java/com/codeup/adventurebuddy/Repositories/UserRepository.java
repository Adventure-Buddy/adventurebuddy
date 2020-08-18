package com.codeup.adventurebuddy.Repositories;

import com.codeup.adventurebuddy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface UserRepository extends JpaRepository<User, Long> {
        User findByUsername(String username);
    }
