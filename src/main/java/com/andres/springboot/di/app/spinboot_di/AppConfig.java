package com.andres.springboot.di.app.spinboot_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.andres.springboot.di.app.spinboot_di.repositories.IProductRepository;
import com.andres.springboot.di.app.spinboot_di.repositories.ProductRespositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

   // private final IProductRepository iProductRepository;

   // AppConfig(IProductRepository iProductRepository) {
      //  this.iProductRepository = iProductRepository;
   // }
    
@Bean// Este método construye un objeto importante. Quiero que tú lo crees, lo guardes y lo prestes cuando alguien lo necesite.
//@Primary
public IProductRepository iProductRepository2 (){
    return new ProductRespositoryJson();
}


}
