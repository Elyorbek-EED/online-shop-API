package com.example.onlineMagazin.mappers.productPrice;

import com.example.onlineMagazin.dto.productPrice.ProductPriceCreateDto;
import com.example.onlineMagazin.dto.productPrice.ProductPriceDto;
import com.example.onlineMagazin.dto.productPrice.ProductPriceUpdateDto;
import com.example.onlineMagazin.entity.productPrice.ProductPrice;
import com.example.onlineMagazin.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ProductPriceMapper extends BaseMapper<ProductPrice, ProductPriceDto, ProductPriceCreateDto, ProductPriceUpdateDto> {
    @Override
    ProductPriceDto toDto(ProductPrice productPrice);

    @Override
    List<ProductPriceDto> toDto(List<ProductPrice> e);

    @Override
    ProductPrice fromCreateDto(ProductPriceCreateDto productPriceCreateDto);

    @Override
    ProductPrice fromUpdateDto(ProductPriceUpdateDto d);
}
