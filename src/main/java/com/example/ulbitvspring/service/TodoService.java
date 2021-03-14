package com.example.ulbitvspring.service;

import com.example.ulbitvspring.entity.TodoEntity;
import com.example.ulbitvspring.entity.UserEntity;
import com.example.ulbitvspring.model.ToDo;
import com.example.ulbitvspring.repo.TodoRepo;
import com.example.ulbitvspring.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;

    public ToDo createTodo(TodoEntity todo, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return ToDo.toModel(todoRepo.save(todo));
    }

    public ToDo complete(Long id){
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return ToDo.toModel(todoRepo.save(todo));
    }

}
