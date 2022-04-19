package com.example.onlineMagazin.validator.productLike;

import com.example.onlineMagazin.dto.productLike.ProductLikeCreateDto;
import com.example.onlineMagazin.dto.productLike.ProductLikeDto;
import com.example.onlineMagazin.dto.productLike.ProductLikeUpdateDto;
import com.example.onlineMagazin.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;

@Component
public class ProductLikeValidator extends AbstractValidator<ProductLikeCreateDto, ProductLikeUpdateDto, Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validateOnCreate(ProductLikeCreateDto productLikeCreateDto) throws ValidationException {

    }

    @Override
    public void validateOnUpdate(ProductLikeUpdateDto productLikeUpdateDto) throws ValidationException {

    }
}
