package com.andres.springboot.di.app.spinboot_di.repositories;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.andres.springboot.di.app.spinboot_di.models.Product;

//@Primary le dice que voy a usar  este respositorio por defecto
@Repository("productFoo")
public class ProductRepositoryFoo implements IProductRepository {

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L,"Monitor ASUS 27",600L));
    }

    @Override
    public Optional<Product> findById(long id) {
        return Optional.ofNullable(new Product(id,"Monitor ASUS 27",600L));
    }

}
