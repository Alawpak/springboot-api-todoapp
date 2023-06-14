package com.springboot.api.todoapp.mapper;

//mapear lo que entra y lo convierte a O
public interface IMapper <I, O>{
    public O map(I in);
}
