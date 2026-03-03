package com.andres.springboot.di.app.spinboot_di.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.andres.springboot.di.app.spinboot_di.models.Product;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;


//esta clase la vamos a implemtentar para que esta sea una clase spring

public class ProductRespositoryJson implements IProductRepository {


    private List<Product>list;

    //CONSTRUCTOR
    public ProductRespositoryJson() {
    Resource resource= new ClassPathResource("json/product.json");
    ObjectMapper objectMapper = new ObjectMapper();
    try {
        list=Arrays.asList(objectMapper.readValue(resource.getFile(),Product[].class));
    } catch (JacksonException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    

    //METODOS DE LA INTERFAZ
    @Override
    public List<Product> findAll() {
        return list;
    }


@Override
public Optional<Product> findById(long id) {
    return list.stream()
                .filter(p -> p.getId() ==id)
                .findFirst();
}




}
