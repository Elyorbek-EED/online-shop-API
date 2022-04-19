package com.example.onlineMagazin.validator.color;

import com.example.onlineMagazin.dto.color.ColorCreateDto;
import com.example.onlineMagazin.dto.color.ColorUpdateDto;
import com.example.onlineMagazin.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;

@Component
public class ColorValidator extends AbstractValidator<ColorCreateDto, ColorUpdateDto, Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validateOnCreate(ColorCreateDto colorCreateDto) throws ValidationException {

    }

    @Override
    public void validateOnUpdate(ColorUpdateDto colorUpdateDto) throws ValidationException {

    }
}
