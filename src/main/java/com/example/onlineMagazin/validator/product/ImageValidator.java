package com.example.onlineMagazin.validator.product;

import com.example.onlineMagazin.dto.GenericDto;
import com.example.onlineMagazin.dto.productImage.ImageCreateDto;
import com.example.onlineMagazin.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;

@Component
public class ImageValidator extends AbstractValidator<
        ImageCreateDto,
        GenericDto,
        Long
        > {
    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validateOnCreate(ImageCreateDto imageCreateDto) throws ValidationException {

    }

    @Override
    public void validateOnUpdate(GenericDto genericDto) throws ValidationException {

    }
}
