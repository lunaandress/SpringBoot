package com.andres.springboot.app.springboot_crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andres.springboot.app.springboot_crud.entities.Product;
import com.andres.springboot.app.springboot_crud.repositories.ProductRepository;

@Service
public class ProductServiceImple implements ProductService  {


    //REPOSITORY
    @Autowired
    private ProductRepository repository;



    //METODOS DE SERVICE

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) repository.findAll() ;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
            return repository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Transactional
    @Override
    public Optional<Product> delete(Product product) {
        Optional<Product> productDb=repository.findById(product.getId());
        productDb.ifPresent(pro ->{
            repository.delete(product);
        });
        return productDb;
    }

}
