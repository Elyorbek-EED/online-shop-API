package com.example.onlineMagazin.validator.productRatingType;

import com.example.onlineMagazin.dto.productRatingType.ProductRatingTypeCreateDto;
import com.example.onlineMagazin.dto.productRatingType.ProductRatingTypeUpdateDto;
import com.example.onlineMagazin.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;

@Component
public class ProductRatingTypeValidator extends AbstractValidator<ProductRatingTypeCreateDto, ProductRatingTypeUpdateDto, Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validateOnCreate(ProductRatingTypeCreateDto productRatingTypeCreateDto) throws ValidationException {

    }

    @Override
    public void validateOnUpdate(ProductRatingTypeUpdateDto productRatingTypeUpdateDto) throws ValidationException {

    }
}
