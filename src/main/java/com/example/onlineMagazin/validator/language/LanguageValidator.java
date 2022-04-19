package com.example.onlineMagazin.validator.language;

import com.example.onlineMagazin.dto.language.LanguageCreateDto;
import com.example.onlineMagazin.dto.language.LanguageUpdateDto;
import com.example.onlineMagazin.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;

@Component
public class LanguageValidator extends AbstractValidator<LanguageCreateDto, LanguageUpdateDto, Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validateOnCreate(LanguageCreateDto languageCreateDto) throws ValidationException {

    }

    @Override
    public void validateOnUpdate(LanguageUpdateDto languageUpdateDto) throws ValidationException {

    }
}
