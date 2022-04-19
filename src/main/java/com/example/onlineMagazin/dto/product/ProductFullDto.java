package com.example.onlineMagazin.dto.product;

import com.example.onlineMagazin.dto.productColor.ProductColorNameDto;
import com.example.onlineMagazin.dto.productComment.ProductCommentNameDto;
import com.example.onlineMagazin.dto.productImage.ImageDto;
import com.example.onlineMagazin.dto.productImage.ImagePathDto;
import com.example.onlineMagazin.dto.productSize.ProductSizeNameDto;
import com.example.onlineMagazin.entity.product.ProductColor;
import com.example.onlineMagazin.entity.product.ProductComment;
import com.example.onlineMagazin.entity.product.ProductSize;
import com.example.onlineMagazin.entity.status.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductFullDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Boolean is_new;
    private List<ImagePathDto> images;
    private List<ProductSizeNameDto> sizes;
    private List<ProductColorNameDto> colors;
    private List<ProductCommentNameDto> comments;
}
