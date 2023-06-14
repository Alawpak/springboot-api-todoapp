package com.springboot.api.todoapp.persistence.repository;

import com.springboot.api.todoapp.persistence.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
