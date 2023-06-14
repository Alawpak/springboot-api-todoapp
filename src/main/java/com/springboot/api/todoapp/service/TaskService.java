package com.springboot.api.todoapp.service;

import com.springboot.api.todoapp.mapper.TaskInDTOToTask;
import com.springboot.api.todoapp.persistence.entity.Task;
import com.springboot.api.todoapp.persistence.entity.TaskStatus;
import com.springboot.api.todoapp.persistence.repository.TaskRepository;
import com.springboot.api.todoapp.service.dto.TaskInDTO;
import org.springframework.stereotype.Service;

import java.util.List;

//servicio se conecta a repositorio y repositorio a al bd
@Service
public class TaskService {

    private final TaskRepository repository;

    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDTO){
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task); //devuelve la entidad que se creo
    }

    public List<Task> findAll(){
        return this.repository.findAll();
    }

    public List<Task> findAllByTaskStatus(TaskStatus taskStatus){
        return this.repository.findAllByTaskStatus(taskStatus);
    }
}
