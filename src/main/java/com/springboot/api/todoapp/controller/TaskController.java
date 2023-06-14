package com.springboot.api.todoapp.controller;

import com.springboot.api.todoapp.persistence.entity.Task;
import com.springboot.api.todoapp.persistence.entity.TaskStatus;
import com.springboot.api.todoapp.service.TaskService;
import com.springboot.api.todoapp.service.dto.TaskInDTO;
import io.swagger.models.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO){
        return this.taskService.createTask(taskInDTO);
    }

    @GetMapping
    public List<Task> findAll(){
        return this.taskService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> findAllByTaksStatus(@PathVariable("status") TaskStatus taskStatus){

        return this.taskService.findAllByTaskStatus(taskStatus);
    }

    //al hacer update o delete es bueno devolver algo con el status 204
    @PatchMapping("/mark_as_finished/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable("id") Long id){
        this.taskService.markTaskAsFinished(id);
        return ResponseEntity.noContent().build();
    }
}
