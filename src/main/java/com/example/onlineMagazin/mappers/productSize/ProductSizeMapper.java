package com.example.onlineMagazin.mappers.productSize;

import com.example.onlineMagazin.dto.productSize.ProductSizeCreateDto;
import com.example.onlineMagazin.dto.productSize.ProductSizeDto;
import com.example.onlineMagazin.dto.productSize.ProductSizeUpdateDto;
import com.example.onlineMagazin.entity.product.ProductSize;
import com.example.onlineMagazin.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ProductSizeMapper extends BaseMapper<ProductSize, ProductSizeDto, ProductSizeCreateDto, ProductSizeUpdateDto> {
    @Override
    ProductSizeDto toDto(ProductSize productSize);

    @Override
    List<ProductSizeDto> toDto(List<ProductSize> e);

    @Override
    ProductSize fromCreateDto(ProductSizeCreateDto productSizeCreateDto);

    @Override
    ProductSize fromUpdateDto(ProductSizeUpdateDto d);
}
