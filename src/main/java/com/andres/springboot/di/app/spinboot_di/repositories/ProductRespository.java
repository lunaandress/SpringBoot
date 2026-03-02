package com.andres.springboot.di.app.spinboot_di.repositories;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.andres.springboot.di.app.spinboot_di.models.Product;


//transformamos en componente  para inyectar
//@Component @Repository es igual a @Componentes pero especialmente para DAO
@Repository("productList")//nombre que le damos
public class ProductRespository  implements IProductRepository {
    
    //Se encarga del acceso a datos

    private  List<Product> data;

    public ProductRespository() {
        this.data = Arrays.asList(
            new Product(1L,"memoria corsair 32 ", 300L),
            new Product(2L , "Intercor core 9 ",850L),
            new Product(3L,"teclado raiser mini 60%", 180L),
            new Product(4L,"Motherboard gigabyte",490L)
        );
    }

    //metodos
    @Override
    public List<Product>findAll(){
        return data;
    }

    @Override
    public Optional<Product> findById(long id){

    return Optional.ofNullable(data.stream().filter(p -> p.getId() == id).findFirst().orElse(null));
    }




}
