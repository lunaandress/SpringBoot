package com.andres.springboot.app.interceptor.springboot_interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier("loadingTime") // con esto inyecta este interceptor
    private  HandlerInterceptor timInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timInterceptor).addPathPatterns("/app/bar","/app/foo");// esto hace que solo se ejecute en bar el interceptor en terminal ya sea en post o pre
        //registry.addInterceptor(timInterceptor).excludePathPatterns("/app/bar","/app/foo"); // con esto exclue en lo que no quiero que se ejecute
    }
    

}
