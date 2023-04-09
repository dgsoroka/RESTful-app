package com.web.webapp.restfullApp.repository;

import com.web.webapp.restfullApp.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
