package com.example.onlineMagazin.mappers.productRating;

import com.example.onlineMagazin.dto.produdctRating.ProductRatingCreateDto;
import com.example.onlineMagazin.dto.produdctRating.ProductRatingDto;
import com.example.onlineMagazin.dto.produdctRating.ProductRatingUpdateDto;
import com.example.onlineMagazin.entity.productRating.ProductRating;
import com.example.onlineMagazin.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ProductRatingMapper extends BaseMapper<ProductRating, ProductRatingDto, ProductRatingCreateDto, ProductRatingUpdateDto> {
    @Override
    ProductRatingDto toDto(ProductRating productRating);

    @Override
    List<ProductRatingDto> toDto(List<ProductRating> e);

    @Override
    ProductRating fromCreateDto(ProductRatingCreateDto productRatingCreateDto);

    @Override
    ProductRating fromUpdateDto(ProductRatingUpdateDto d);
}
