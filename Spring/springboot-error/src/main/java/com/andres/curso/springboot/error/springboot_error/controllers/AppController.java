package com.andres.curso.springboot.error.springboot_error.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.andres.curso.springboot.error.springboot_error.models.User;
import com.andres.curso.springboot.error.springboot_error.services.UserService;



@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService service;

    @GetMapping
    public String index(){
        int value = Integer.parseInt("10");
        System.out.println(value);
        return "ok 200";
    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable long id) {
        User user =  service.findById(id).orElseThrow(() ->new  UserNotFoundException("SI ES NULL EL USUARIO NO EXISTE"));//aqui le pasamos nuestra clase personalizada );
        System.out.println(user.getLastname());
        return user;
    }
}
    
    

