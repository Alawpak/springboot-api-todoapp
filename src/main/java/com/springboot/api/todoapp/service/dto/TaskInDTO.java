package com.springboot.api.todoapp.service.dto;

import com.springboot.api.todoapp.persistence.entity.TaskStatus;
import lombok.Data;

import java.time.LocalDateTime;

//es una clase para saber que datos se le van a pedir al usuario, ya que algunos se hacen con algoritmo en back
@Data
public class TaskInDTO {

    private String title;
    private String description;
    private LocalDateTime eta;
}
