package com.andres.springboot.di.app.spinboot_di.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.springboot.di.app.spinboot_di.models.Product;
import com.andres.springboot.di.app.spinboot_di.service.ProductService;

//RUTA api
@RestController
@RequestMapping("/api")
public class SomeController {

    //lo instancio para poder traer los datos del  service
    @Autowired
    private ProductService service ;
    //private ProductService service = new ProductService();

    //RUTA
    @GetMapping
    public List<Product>list(){
        return service.findAll();
    }


    //aqui va a buscar por id en la ruta nosotros le metros el id
    @GetMapping("/{id}")
    public Optional<Product> show(@PathVariable long id){
        return service.findById(id);
    }

}
