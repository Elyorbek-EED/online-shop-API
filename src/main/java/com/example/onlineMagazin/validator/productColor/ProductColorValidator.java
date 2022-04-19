package com.example.onlineMagazin.validator.productColor;

import com.example.onlineMagazin.dto.productColor.ProductColorCreateDto;
import com.example.onlineMagazin.dto.productColor.ProductColorDto;
import com.example.onlineMagazin.dto.productColor.ProductColorUpdateDto;
import com.example.onlineMagazin.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;

@Component
public class ProductColorValidator extends AbstractValidator<ProductColorCreateDto, ProductColorUpdateDto, Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validateOnCreate(ProductColorCreateDto productColorCreateDto) throws ValidationException {

    }

    @Override
    public void validateOnUpdate(ProductColorUpdateDto productColorUpdateDto) throws ValidationException {

    }
}
