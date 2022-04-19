package com.example.onlineMagazin.validator.role;

import com.example.onlineMagazin.dto.role.RoleCreateDto;
import com.example.onlineMagazin.dto.role.RoleUpdateDto;
import com.example.onlineMagazin.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;

@Component
public class RoleValidator extends AbstractValidator<RoleCreateDto, RoleUpdateDto, Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validateOnCreate(RoleCreateDto roleCreateDto) throws ValidationException {

    }

    @Override
    public void validateOnUpdate(RoleUpdateDto roleUpdateDto) throws ValidationException {

    }
}
