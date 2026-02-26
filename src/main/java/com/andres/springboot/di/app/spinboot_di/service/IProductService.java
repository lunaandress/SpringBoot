package com.andres.springboot.di.app.spinboot_di.service;

import java.util.List;
import java.util.Optional;

import com.andres.springboot.di.app.spinboot_di.models.Product;

public interface IProductService {

    public List<Product>findAll();
    public Optional<Product> findById(long id);

}
