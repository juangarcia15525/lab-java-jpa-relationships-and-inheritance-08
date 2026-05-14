package com.ironhack.jpalab.repository;

import com.ironhack.jpalab.event.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {}