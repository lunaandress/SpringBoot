package com.andres.springboot.app.springboot_crud.service;

import java.util.List;
import java.util.Optional;

import com.andres.springboot.app.springboot_crud.entities.Product;

public interface ProductService {

    List<Product>findAll();
    Optional <Product> findById(Long id);// el Opcional es in contenedor que solo puede tener  0 a 1 Objeto
    Product save(Product product);
    Optional<Product> delete(Product product);

}
