package com.example.onlineMagazin.validator.productSize;

import com.example.onlineMagazin.dto.productSize.ProductSizeCreateDto;
import com.example.onlineMagazin.dto.productSize.ProductSizeUpdateDto;
import com.example.onlineMagazin.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;

@Component
public class ProductSizeValidator extends AbstractValidator<ProductSizeCreateDto, ProductSizeUpdateDto, Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validateOnCreate(ProductSizeCreateDto productSizeCreateDto) throws ValidationException {

    }

    @Override
    public void validateOnUpdate(ProductSizeUpdateDto productSizeUpdateDto) throws ValidationException {

    }
}
