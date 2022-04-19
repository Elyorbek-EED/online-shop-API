package com.example.onlineMagazin.validator.productComment;

import com.example.onlineMagazin.dto.productComment.ProductCommentCreateDto;
import com.example.onlineMagazin.dto.productComment.ProductCommentUpdateDto;
import com.example.onlineMagazin.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;

@Component
public class ProductCommentValidator extends AbstractValidator<ProductCommentCreateDto, ProductCommentUpdateDto, Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validateOnCreate(ProductCommentCreateDto productCommentCreateDto) throws ValidationException {

    }

    @Override
    public void validateOnUpdate(ProductCommentUpdateDto productCommentUpdateDto) throws ValidationException {

    }
}
