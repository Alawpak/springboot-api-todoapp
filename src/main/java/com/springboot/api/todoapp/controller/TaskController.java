package com.springboot.api.todoapp.controller;

import com.springboot.api.todoapp.persistence.entity.Task;
import com.springboot.api.todoapp.persistence.entity.TaskStatus;
import com.springboot.api.todoapp.service.TaskService;
import com.springboot.api.todoapp.service.dto.TaskInDTO;
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
}
