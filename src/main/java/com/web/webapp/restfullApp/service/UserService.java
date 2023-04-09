package com.web.webapp.restfullApp.service;

import com.web.webapp.restfullApp.entity.UserEntity;
import com.web.webapp.restfullApp.exception.UserAlreadyExistException;
import com.web.webapp.restfullApp.exception.UserNotFoundException;
import com.web.webapp.restfullApp.model.User;
import com.web.webapp.restfullApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if(userRepo.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        }
        return  userRepo.save(user);
    }

    public User getOne (Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if(user == null){
            throw new UserNotFoundException("Пользователь не найден");
        }
        return User.toModel(user);
    }

    public Long deleteUser(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
