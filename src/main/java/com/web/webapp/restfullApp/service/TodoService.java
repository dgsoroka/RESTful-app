package com.web.webapp.restfullApp.service;

import com.web.webapp.restfullApp.entity.ToDoEntity;
import com.web.webapp.restfullApp.entity.UserEntity;
import com.web.webapp.restfullApp.exception.UserNotFoundException;
import com.web.webapp.restfullApp.model.ToDo;
import com.web.webapp.restfullApp.repository.ToDoRepo;
import com.web.webapp.restfullApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private ToDoRepo toDoRepo;

    @Autowired
    private UserRepo userRepo;

    public ToDo createToDo (ToDoEntity toDo, Long userId) throws UserNotFoundException {
        UserEntity user = userRepo.findById(userId).get();
        if(user == null){throw new UserNotFoundException("Пользователь не найден");}
        toDo.setUser(user);
        return ToDo.toModel(toDoRepo.save(toDo));
    }

    public ToDo completeToDo (Long id) {
        ToDoEntity toDo = toDoRepo.findById(id).get();
        toDo.setCompleted(!toDo.getCompleted());
        return ToDo.toModel(toDoRepo.save(toDo));
    }
}
