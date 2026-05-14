package com.ironhack.jpalab.repository;

import com.ironhack.jpalab.nurse.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DivisionRepository extends JpaRepository<Division, Long> {
    List<Division> findByDistrict(String district);
}