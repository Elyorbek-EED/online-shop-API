package com.example.onlineMagazin.validator.productRating;

import com.example.onlineMagazin.dto.produdctRating.ProductRatingCreateDto;
import com.example.onlineMagazin.dto.produdctRating.ProductRatingUpdateDto;
import com.example.onlineMagazin.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;

@Component
public class ProductRatingValidator extends AbstractValidator<ProductRatingCreateDto, ProductRatingUpdateDto, Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validateOnCreate(ProductRatingCreateDto productRatingCreateDto) throws ValidationException {

    }

    @Override
    public void validateOnUpdate(ProductRatingUpdateDto productRatingUpdateDto) throws ValidationException {

    }
}
