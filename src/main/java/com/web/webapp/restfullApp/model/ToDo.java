package com.web.webapp.restfullApp.model;

import com.web.webapp.restfullApp.entity.ToDoEntity;

public class ToDo {
    private Long id;
    private String title;
    private Boolean completed;


    public static ToDo toModel(ToDoEntity toDo){
        ToDo model = new ToDo();
        model.setId(toDo.getId());
        model.setCompleted(toDo.getCompleted());
        model.setTitle(toDo.getTitle());
        return model;
    }


    public ToDo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
