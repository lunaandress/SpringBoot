package com.andres.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//Spring AOP que indica que una clase contiene aspectos (código que intercepta
// métodos para añadir comportamiento como logs, seguridad, etc.
@Aspect
@Component
public class GreetingAspect {
    private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    //JoinPoint es un punto de union con un aspecto Aspecto
    //Before le decimos donde lo vamos a interceptar a que metodo
    @Before("execution(String com.andres.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    public void loggerBefore(JoinPoint joinPoint){
        String method= joinPoint.getSignature().getName();
        String args=Arrays.toString(joinPoint.getArgs());
        logger.info(" Antes " + method + " " + args);
    }

    @After("execution(String com.andres.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    public void loggerAfter(JoinPoint joinPoint){
        String method= joinPoint.getSignature().getName();
        String args=Arrays.toString(joinPoint.getArgs());
        logger.info(" Despues " + method + " " + args);
    }



/////////////////////////////////////////////////////////////////


    //Anotación de Spring AOP que ejecuta un método después de que
    //otro método termina correctamente (sin excepción)
    @AfterReturning("execution(String com.andres.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    public void oggerAfterReturning(JoinPoint joinPoint){
        String method= joinPoint.getSignature().getName();
        String args=Arrays.toString(joinPoint.getArgs());
        logger.info(" Despues de retornar  " + method + " " + args);
    }
    //Anotación de Spring AOP que ejecuta un método
    //cuando el método interceptado lanza una excepción.
        @AfterThrowing("execution(String com.andres.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    public void loggerAfterThrowing(JoinPoint joinPoint){
        String method= joinPoint.getSignature().getName();
        String args=Arrays.toString(joinPoint.getArgs());
        logger.info(" Despues de lanzar la excepcion " + method + " " + args);
    }

    //Anotación de Spring AOP que envuelve la ejecución de un método, permitiendo ejecutar código antes y después,
    //e incluso controlar si el método se ejecuta o no.
    @Around("execution(String com.andres.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable{
        String method= joinPoint.getSignature().getName();
        String args=Arrays.toString(joinPoint.getArgs());

        Object result = joinPoint.proceed();
        logger.info("El metodo " + method + "() con lso parametros " + args);
        logger.info("El metodo  " + method + "() retorna el resultado : " + result);
        
        return result;

    }
}


