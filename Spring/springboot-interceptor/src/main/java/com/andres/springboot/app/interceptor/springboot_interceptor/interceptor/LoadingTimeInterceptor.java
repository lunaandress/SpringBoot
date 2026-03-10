package com.andres.springboot.app.interceptor.springboot_interceptor.interceptor;

import java.util.Random;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//@Component le dice a Spring: “crea y gestiona automáticamente una instancia de esta clase
// para que pueda ser inyectada en otras partes de la aplicación.”
@Component("loadingTime")
public class LoadingTimeInterceptor implements HandlerInterceptor{    //PARA CREAR UN INTERCEPTOR  EN LA CLASE IMPLEMENTAMOS EL HandlerInterceptor

    //PRE
        @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
                HandlerMethod controller=((HandlerMethod)handler);
                logger.info("LoadingTimeInterceptor:pretHanfle() entrando..." +  controller.getMethod().getName());
                
                long start= System.currentTimeMillis();
                request.setAttribute("start",start);

                Random random = new Random();
                    int delay= random.nextInt(500);
                    Thread.sleep(delay);

                    //vamos a personalizar INTERCERPTOR CUNAND ES FALSE
/*                     Map<String,String>json = new HashMap<>();
                    json.put("error", "no tienes acceso a esta paguina!");
                    json.put("date", new Date().toString());

                    ObjectMapper mapper = new ObjectMapper();
                    String jsonString= mapper.writeValueAsString(json);
                    response.setContentType("application/json");
                    response.setStatus(401);
                    response.getWriter().write(jsonString);; */
                    return true;
    }

    //POST
    //Sirve para registrar mensajes en el log de la aplicación.
    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {


                long end = System.currentTimeMillis();
                long start= (long) request.getAttribute("start");
                long result = end - start;
                logger.info("tiempo transcurrido:"+ result);

                logger.info("LoadingTimeInterceptor:prostHanfle() saliendo...");
    }


    
}
