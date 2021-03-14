package com.example.ulbitvspring.repo;

import com.example.ulbitvspring.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
   UserEntity findByUsername(String username);
}
