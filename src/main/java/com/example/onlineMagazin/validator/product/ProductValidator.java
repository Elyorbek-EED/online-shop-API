package com.example.onlineMagazin.validator.product;

import com.example.onlineMagazin.dto.product.ProductCreateDto;
import com.example.onlineMagazin.dto.product.ProductUpdateDto;
import com.example.onlineMagazin.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 15.03.2022 20:33
 * Project : onlineMagazin
 */
@Component
public class ProductValidator extends AbstractValidator<ProductCreateDto, ProductUpdateDto,Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validateOnCreate(ProductCreateDto productCreateDto) throws ValidationException {

    }

    @Override
    public void validateOnUpdate(ProductUpdateDto productUpdateDto) throws ValidationException {

    }
}
