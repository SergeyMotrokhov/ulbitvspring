package com.example.ulbitvspring.service;

import com.example.ulbitvspring.entity.UserEntity;
import com.example.ulbitvspring.exception.UserAlreadyExistsException;
import com.example.ulbitvspring.exception.UserNotFoundException;
import com.example.ulbitvspring.model.User;
import com.example.ulbitvspring.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistsException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistsException("Пользователь с таким именем уже существует");
        }
        return userRepo.save(user);
    }

//    public UserEntity getOne(Long id) throws UserNotFoundException {
//        UserEntity user = userRepo.findById(id).get();
//        if (user == null){
//            throw new UserNotFoundException("Пользователь не найден");
//        }
//        return user;
//    } //тут возвращает с паролем


    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null){
            throw new UserNotFoundException("Пользователь не найден");
        }
        return User.toModel(user);
    }

    public Long delete(Long id){
        userRepo.deleteById(id);
        return id;
    }



}
