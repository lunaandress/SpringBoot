package com.andres.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
@Aspect// con esto le digo a Spring que es un Aspecto
public class GreetingFooAspect {

    //esto sitrve para crear logs para ver en la terminal
    Logger logger = LoggerFactory.getLogger(getClass());

    @Before("greetingFooPointCut")
    public void loggerBefore(JoinPoint joinPoint){
        String method= joinPoint.getSignature().getName();
        String args=Arrays.toString(joinPoint.getArgs());
        logger.info(" Antes " + method + " " + args);
    }


        @After("greetingFooPointCut")
    public void loggerAfter(JoinPoint joinPoint){
        String method= joinPoint.getSignature().getName();
        String args=Arrays.toString(joinPoint.getArgs());
        logger.info(" Despues primero " + method + "invocado con los parametros " + args);
    }
}
