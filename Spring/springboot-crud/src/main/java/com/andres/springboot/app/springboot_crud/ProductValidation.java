package com.andres.springboot.app.springboot_crud;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.andres.springboot.app.springboot_crud.entities.Product;


@Component
public class ProductValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
    return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    Product product= (Product) target;
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.product.name");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotBlank.product.description");
    }

}
