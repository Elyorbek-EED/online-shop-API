package com.example.onlineMagazin.mappers.productColor;

import com.example.onlineMagazin.dto.productColor.ProductColorCreateDto;
import com.example.onlineMagazin.dto.productColor.ProductColorDto;
import com.example.onlineMagazin.dto.productColor.ProductColorUpdateDto;
import com.example.onlineMagazin.entity.product.ProductColor;
import com.example.onlineMagazin.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ProductColorMapper extends BaseMapper<ProductColor, ProductColorDto, ProductColorCreateDto, ProductColorUpdateDto> {
    @Override
    ProductColorDto toDto(ProductColor productColor);

    @Override
    List<ProductColorDto> toDto(List<ProductColor> e);

    @Override
    ProductColor fromCreateDto(ProductColorCreateDto productColorCreateDto);

    @Override
    ProductColor fromUpdateDto(ProductColorUpdateDto d);
}
