package com.andres.curso.springboot.error.springboot_error.controllers;


import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.andres.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.andres.curso.springboot.error.springboot_error.models.ErrorC;



// @RestControllerAdvice : Permite capturar excepciones y devolver respuestas JSON bonitas
// sin tener que poner try-catch en cada controlador.
//PRIMERA FORMA PARA VISUAL ERROES DE FORMA MAS ORDENADA Y CUSTOMISAR
@RestControllerAdvice
public class HandlerExceptionController {


@ExceptionHandler(ArithmeticException.class)
public ResponseEntity<ErrorC>divisionByZero(Exception ex){
    ErrorC errorC= new ErrorC();
    errorC.setDate(new Date(0));
    errorC.setError("Error divicion cero");
    errorC.setMessage(ex.getMessage());
    errorC.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
return ResponseEntity.internalServerError().body(errorC);

    }

// una sola execpcion por eso no se pone las llaves {}
@ExceptionHandler(NoHandlerFoundException.class)
public ResponseEntity<ErrorC>noFoundEx(NoHandlerFoundException e){
    ErrorC errorC= new ErrorC();
    errorC.setDate(new Date(0));
    errorC.setError("Api rest no encontrada ");
    errorC.setMessage(e.getMessage());
    errorC.setStatus(HttpStatus.NOT_FOUND.value());

return ResponseEntity.status(404).body(errorC);

}

@ExceptionHandler(NumberFormatException.class)
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public Map<String,Object>NumberFormatException(Exception ex){
Map<String, Object >error= new HashMap<>();
error.put("date", new Date(0).toString());
error.put("error", "numero invalido o incorrecto  no tiene forma de digito!");
error.put("mesagge",ex.getMessage());
error.put("status",HttpStatus.INTERNAL_SERVER_ERROR.value());
    return error;
}

//AQUI PUEDO AGREGAR MI EXCEPCION PERZONALIZADA
@ExceptionHandler({NullPointerException.class,
                    HttpMessageNotWritableException.class,
                    UserNotFoundException.class})
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public Map<String,Object>userNotFoundException(Exception ex){
Map<String, Object >error= new HashMap<>();
error.put("date", new Date(0).toString());
error.put("error", "Rol no existe!");
error.put("mesagge",ex.getMessage());
error.put("status",HttpStatus.INTERNAL_SERVER_ERROR.value());
    return error;
}

//HttpMessageNotWritableException



}
