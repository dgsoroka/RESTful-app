package com.web.webapp.restfullApp.model;

import com.web.webapp.restfullApp.entity.ToDoEntity;
import com.web.webapp.restfullApp.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class User {
    private Long id;
    private String username;
    private List<ToDo> toDos;


    public static User toModel(UserEntity entity){
        User model = new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setToDos(entity.getTodos().stream().map(ToDo::toModel).collect(Collectors.toList()));
        return model;
    }


    public User() {
    }

    public List<ToDo> getToDos() {
        return toDos;
    }

    public void setToDos(List<ToDo> toDos) {
        this.toDos = toDos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
