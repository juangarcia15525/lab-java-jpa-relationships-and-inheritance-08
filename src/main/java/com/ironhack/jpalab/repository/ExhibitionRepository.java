package com.ironhack.jpalab.repository;

import com.ironhack.jpalab.event.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExhibitionRepository extends JpaRepository<Exhibition, Long> {}