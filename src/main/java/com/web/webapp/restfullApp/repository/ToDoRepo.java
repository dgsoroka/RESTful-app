package com.web.webapp.restfullApp.repository;

import com.web.webapp.restfullApp.entity.ToDoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepo extends CrudRepository<ToDoEntity, Long> {
}
