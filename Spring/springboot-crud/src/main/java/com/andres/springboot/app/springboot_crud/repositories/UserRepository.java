package com.andres.springboot.app.springboot_crud.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.andres.springboot.app.springboot_crud.entities.User;

public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findByUserName(String username);

}
