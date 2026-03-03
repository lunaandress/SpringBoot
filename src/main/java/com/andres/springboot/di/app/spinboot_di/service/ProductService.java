package com.andres.springboot.di.app.spinboot_di.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.andres.springboot.di.app.spinboot_di.models.Product;
import com.andres.springboot.di.app.spinboot_di.repositories.IProductRepository;

@Service
public class ProductService implements IProductService {

    @Autowired
    private Environment environment;

    @Value("${config.price.tax}")
    private Double tax;

    private final IProductRepository repository;

    // Inyección por constructor (no necesita @Autowired)
    public ProductService(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {

        return repository.findAll().stream().map(p -> {
                    System.out.println(tax);
                    Double priceTax = p.getPrice() * environment.getProperty("config.price.tax",Double.class);
                    Product newProduct = (Product) p.clone();
                    newProduct.setPrice(priceTax.longValue());
                    return newProduct;
                   // p.setPrice(priceTax.longValue());
                    //return p;
            
                })
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(long id) {
        return repository.findById(id);
    }
}