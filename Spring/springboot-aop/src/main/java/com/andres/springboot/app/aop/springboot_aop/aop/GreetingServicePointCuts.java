package com.andres.springboot.app.aop.springboot_aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GreetingServicePointCuts {
    @Pointcut("execution(String com.andres.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    private void  greetingLoggerPointCut (){}


    @Pointcut("execution(String com.andres.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    private void greetingFooPointCut(){};
}
