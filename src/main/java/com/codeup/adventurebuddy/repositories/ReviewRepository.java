package com.codeup.adventurebuddy.repositories;

import com.codeup.adventurebuddy.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository <Review,Long> {
}
