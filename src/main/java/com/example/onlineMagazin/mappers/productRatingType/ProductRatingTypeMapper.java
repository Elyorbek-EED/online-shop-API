package com.example.onlineMagazin.mappers.productRatingType;

import com.example.onlineMagazin.dto.productRatingType.ProductRatingTypeCreateDto;
import com.example.onlineMagazin.dto.productRatingType.ProductRatingTypeDto;
import com.example.onlineMagazin.dto.productRatingType.ProductRatingTypeUpdateDto;
import com.example.onlineMagazin.entity.productRating.ProductRatingType;
import com.example.onlineMagazin.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ProductRatingTypeMapper extends BaseMapper<ProductRatingType, ProductRatingTypeDto, ProductRatingTypeCreateDto, ProductRatingTypeUpdateDto> {
    @Override
    ProductRatingTypeDto toDto(ProductRatingType productRatingType);

    @Override
    List<ProductRatingTypeDto> toDto(List<ProductRatingType> e);

    @Override
    ProductRatingType fromCreateDto(ProductRatingTypeCreateDto productRatingTypeCreateDto);

    @Override
    ProductRatingType fromUpdateDto(ProductRatingTypeUpdateDto d);
}
