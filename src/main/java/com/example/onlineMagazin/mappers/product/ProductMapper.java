package com.example.onlineMagazin.mappers.product;

import com.example.onlineMagazin.dto.product.ProductCreateDto;
import com.example.onlineMagazin.dto.product.ProductDto;
import com.example.onlineMagazin.dto.product.ProductFullDto;
import com.example.onlineMagazin.dto.product.ProductUpdateDto;
import com.example.onlineMagazin.entity.product.Product;
import com.example.onlineMagazin.mappers.BaseMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 15.03.2022 20:05
 * Project : onlineMagazin
 */

@Component
@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseMapper <
        Product,
        ProductDto,
        ProductCreateDto,
        ProductUpdateDto>{


    @Override
    ProductDto toDto(Product product);

    @Override
    List<ProductDto> toDto(List<Product> e);

    @Override
    Product fromCreateDto(ProductCreateDto productCreateDto);

    @Override
    Product fromUpdateDto(ProductUpdateDto d);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product fromUpdateDto(ProductUpdateDto d, @MappingTarget Product product);

}
