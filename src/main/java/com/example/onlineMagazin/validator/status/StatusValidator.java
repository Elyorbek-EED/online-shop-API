package com.example.onlineMagazin.validator.status;

import com.example.onlineMagazin.dto.status.StatusCreateDto;
import com.example.onlineMagazin.dto.status.StatusUpdateDto;
import com.example.onlineMagazin.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;

@Component
public class StatusValidator extends AbstractValidator<StatusCreateDto, StatusUpdateDto, Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validateOnCreate(StatusCreateDto statusCreateDto) throws ValidationException {

    }

    @Override
    public void validateOnUpdate(StatusUpdateDto statusUpdateDto) throws ValidationException {

    }
}
