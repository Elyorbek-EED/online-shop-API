package com.example.onlineMagazin.mappers.category;

import com.example.onlineMagazin.dto.category.CategoryCreateDto;
import com.example.onlineMagazin.dto.category.CategoryDto;
import com.example.onlineMagazin.dto.category.CategoryUpdateDto;
import com.example.onlineMagazin.entity.category.Category;
import com.example.onlineMagazin.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<Category, CategoryDto, CategoryCreateDto, CategoryUpdateDto> {
    @Override
    CategoryDto toDto(Category category);

    @Override
    List<CategoryDto> toDto(List<Category> e);

    @Override
    Category fromCreateDto(CategoryCreateDto categoryCreateDto);

    @Override
    Category fromUpdateDto(CategoryUpdateDto d);
}
