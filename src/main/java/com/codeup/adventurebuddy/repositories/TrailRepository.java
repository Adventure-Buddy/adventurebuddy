package com.codeup.adventurebuddy.repositories;
import com.codeup.adventurebuddy.models.Trail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrailRepository extends JpaRepository<Trail, Long> {
}
