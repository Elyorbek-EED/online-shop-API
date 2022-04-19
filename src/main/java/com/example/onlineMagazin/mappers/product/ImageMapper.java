package com.example.onlineMagazin.mappers.product;

import com.example.onlineMagazin.dto.GenericDto;
import com.example.onlineMagazin.dto.productImage.ImageCreateDto;
import com.example.onlineMagazin.dto.productImage.ImageDto;
import com.example.onlineMagazin.entity.product.ProductImage;
import com.example.onlineMagazin.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ImageMapper extends BaseMapper <
        ProductImage,
        ImageDto,
        ImageCreateDto,
        GenericDto>{
    @Override
    ImageDto toDto(ProductImage productImage);

    @Override
    List<ImageDto> toDto(List<ProductImage> e);

    @Override
    ProductImage fromCreateDto(ImageCreateDto imageCreateDto);
}
