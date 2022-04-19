package com.example.onlineMagazin.validator.category;

import com.example.onlineMagazin.dto.category.CategoryCreateDto;
import com.example.onlineMagazin.dto.category.CategoryUpdateDto;
import com.example.onlineMagazin.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;

@Component
public class CategoryValidator extends AbstractValidator<CategoryCreateDto, CategoryUpdateDto, Long> {

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validateOnCreate(CategoryCreateDto categoryCreateDto) throws ValidationException {

    }

    @Override
    public void validateOnUpdate(CategoryUpdateDto categoryUpdateDto) throws ValidationException {

    }
}
