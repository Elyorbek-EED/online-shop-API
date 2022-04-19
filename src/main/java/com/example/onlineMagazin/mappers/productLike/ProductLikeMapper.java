package com.example.onlineMagazin.mappers.productLike;

import com.example.onlineMagazin.dto.product.ProductOnlyDto;
import com.example.onlineMagazin.dto.productLike.ProductLikeCreateDto;
import com.example.onlineMagazin.dto.productLike.ProductLikeDto;
import com.example.onlineMagazin.dto.productLike.ProductLikeUpdateDto;
import com.example.onlineMagazin.entity.product.Product;
import com.example.onlineMagazin.entity.product.ProductLike;
import com.example.onlineMagazin.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ProductLikeMapper extends BaseMapper<ProductLike, ProductLikeDto, ProductLikeCreateDto, ProductLikeUpdateDto> {

    @Override
    ProductLikeDto toDto(ProductLike productLike);

    @Override
    List<ProductLikeDto> toDto(List<ProductLike> e);

    @Override
    ProductLike fromCreateDto(ProductLikeCreateDto productLikeCreateDto);

    @Override
    ProductLike fromUpdateDto(ProductLikeUpdateDto d);

    ProductOnlyDto fromProductOnlyDto(Product product);
}
