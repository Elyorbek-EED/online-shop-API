package com.example.onlineMagazin.validator.userCart;

import com.example.onlineMagazin.dto.userCart.AuthUserCartCreateDto;
import com.example.onlineMagazin.dto.userCart.AuthUserCartUpdateDto;
import com.example.onlineMagazin.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;

@Component
public class AuthUserCartValidator extends AbstractValidator<AuthUserCartCreateDto, AuthUserCartUpdateDto, Long> {

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validateOnCreate(AuthUserCartCreateDto authUserCartCreateDto) throws ValidationException {

    }

    @Override
    public void validateOnUpdate(AuthUserCartUpdateDto authUserCartUpdateDto) throws ValidationException {

    }
}
