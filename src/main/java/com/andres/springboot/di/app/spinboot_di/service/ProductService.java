package com.andres.springboot.di.app.spinboot_di.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.andres.springboot.di.app.spinboot_di.models.Product;
import com.andres.springboot.di.app.spinboot_di.repositories.IProductRepository;

@Service
public class ProductService implements IProductService {

    private final IProductRepository repository;

    // Inyección por constructor (no necesita @Autowired)
    public ProductService(@Qualifier("productList") IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {

        return repository.findAll().stream().map(p -> {
                    Double priceTax = p.getPrice() * 1.25d;
                    //Product newProduct = (Product) p.clone();
                    //newProduct.setPrice(priceTax.longValue());
                    //return newProduct;
                    p.setPrice(priceTax.longValue());
                    return p;
            
                })
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(long id) {
        return repository.findById(id);
    }
}