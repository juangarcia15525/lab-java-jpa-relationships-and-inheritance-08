package com.ironhack.jpalab.repository;

import com.ironhack.jpalab.event.Guest;
import com.ironhack.jpalab.event.GuestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByStatus(GuestStatus status);
}