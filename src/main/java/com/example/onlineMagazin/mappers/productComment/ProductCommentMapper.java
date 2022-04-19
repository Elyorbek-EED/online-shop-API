package com.example.onlineMagazin.mappers.productComment;

import com.example.onlineMagazin.dto.productComment.ProductCommentCreateDto;
import com.example.onlineMagazin.dto.productComment.ProductCommentDto;
import com.example.onlineMagazin.dto.productComment.ProductCommentUpdateDto;
import com.example.onlineMagazin.entity.product.ProductComment;
import com.example.onlineMagazin.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ProductCommentMapper extends BaseMapper<ProductComment, ProductCommentDto, ProductCommentCreateDto, ProductCommentUpdateDto> {
    @Override
    ProductCommentDto toDto(ProductComment productComment);

    @Override
    List<ProductCommentDto> toDto(List<ProductComment> e);

    @Override
    ProductComment fromCreateDto(ProductCommentCreateDto productCommentCreateDto);

    @Override
    ProductComment fromUpdateDto(ProductCommentUpdateDto d);
}
