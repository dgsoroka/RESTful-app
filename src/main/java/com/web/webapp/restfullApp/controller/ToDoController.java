package com.web.webapp.restfullApp.controller;

import com.web.webapp.restfullApp.entity.ToDoEntity;
import com.web.webapp.restfullApp.exception.UserNotFoundException;
import com.web.webapp.restfullApp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    @Autowired
    TodoService todoService;

    @PostMapping
    public ResponseEntity createToDo(@RequestBody ToDoEntity toDo,
                                     @RequestParam Long userId) {

        try {
            return ResponseEntity.ok(todoService.createToDo(toDo, userId));
        } catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping
    public ResponseEntity completeToDo(@RequestParam Long id) {

        try {
            return ResponseEntity.ok(todoService.completeToDo(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
