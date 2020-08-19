package com.codeup.adventurebuddy.repositories;

import com.codeup.adventurebuddy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("userRepository")
    public interface UserRepository extends JpaRepository<User, Long> {
        User findByUsername(String username);
    }
