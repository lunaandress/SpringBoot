package com.andres.curso.springboot.error.springboot_error.services;

import java.util.List;
import java.util.Optional;

import com.andres.curso.springboot.error.springboot_error.models.User;

public interface UserService {

    List<User>findAll();
    //User findById(long id);
    Optional<User>findById(long id);

}
