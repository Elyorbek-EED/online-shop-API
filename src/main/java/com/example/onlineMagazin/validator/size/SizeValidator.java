package com.example.onlineMagazin.validator.size;

import com.example.onlineMagazin.dto.size.SizeCreateDto;
import com.example.onlineMagazin.dto.size.SizeUpdateDto;
import com.example.onlineMagazin.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;

@Component
public class SizeValidator extends AbstractValidator<SizeCreateDto, SizeUpdateDto, Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validateOnCreate(SizeCreateDto sizeCreateDto) throws ValidationException {

    }

    @Override
    public void validateOnUpdate(SizeUpdateDto sizeUpdateDto) throws ValidationException {

    }
}
