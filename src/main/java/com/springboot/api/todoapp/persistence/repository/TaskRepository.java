package com.springboot.api.todoapp.persistence.repository;

import com.springboot.api.todoapp.persistence.entity.Task;
import com.springboot.api.todoapp.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    public List<Task> findAllByTaskStatus(TaskStatus taskStatus);

    //se pasa la query y se especifica si se va a ejecutar desde la bd o con jpa
    @Modifying
    @Query(value="UPDATE TASK SET FINISHED=TRUE WHERE ID = :id", nativeQuery = true)
    public void markTaskAsFinished(@Param("id") Long id);
}
