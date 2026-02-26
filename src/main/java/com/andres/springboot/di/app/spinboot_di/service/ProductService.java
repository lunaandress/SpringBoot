package com.andres.springboot.di.app.spinboot_di.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andres.springboot.di.app.spinboot_di.models.Product;
import com.andres.springboot.di.app.spinboot_di.repositories.ProductRespository;

//El service accede a los datos mediante al repositorio pero ademas
    //los puede manipular y trabajar con ellos.


//Registramos esta clase como un componente  para hacerlo un COMPONENTE  a esta clase
@Component
public class ProductService implements IProductService {

//Inyectamos el repositorio y asi ya no depende de un new y todo lo maneja desde el ocntrolador 
@Autowired
private ProductRespository respository;

//private ProductRespository respository= new ProductRespository();

//METODOS

@Override
public List<Product>findAll(){
    
    //principio de imutabilidad
    return respository.findAll().stream().map(p -> {
        Double priceTax= p.getPrice() * 1.25d;
       // Product newProduct = new Product(p.getId(),p.getName(),priceImp.longValue());
        Product newProduct =  (Product)p.clone();
        newProduct.setPrice(priceTax.longValue());
        return newProduct;
    }).collect(Collectors.toList());
}

@Override
public Optional<Product> findById(long id){
    return respository.findById(id);
}












}
