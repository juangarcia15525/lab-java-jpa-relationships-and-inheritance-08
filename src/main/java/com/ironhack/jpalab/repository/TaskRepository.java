package com.ironhack.jpalab.repository;

import com.ironhack.jpalab.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {}