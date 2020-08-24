package com.codeup.adventurebuddy.Repositories;

import com.codeup.adventurebuddy.models.EmergencyContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyContactsRepository extends JpaRepository<EmergencyContact,Long> {
}
