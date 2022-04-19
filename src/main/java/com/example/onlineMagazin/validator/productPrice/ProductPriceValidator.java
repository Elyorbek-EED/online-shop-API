package com.example.onlineMagazin.validator.productPrice;

import com.example.onlineMagazin.dto.productPrice.ProductPriceCreateDto;
import com.example.onlineMagazin.dto.productPrice.ProductPriceUpdateDto;
import com.example.onlineMagazin.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;

@Component
public class ProductPriceValidator extends AbstractValidator<ProductPriceCreateDto, ProductPriceUpdateDto, Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validateOnCreate(ProductPriceCreateDto productPriceCreateDto) throws ValidationException {

    }

    @Override
    public void validateOnUpdate(ProductPriceUpdateDto productPriceUpdateDto) throws ValidationException {

    }
}
