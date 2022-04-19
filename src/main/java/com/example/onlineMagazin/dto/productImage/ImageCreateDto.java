package com.example.onlineMagazin.dto.productImage;

import com.example.onlineMagazin.dto.Dto;
import com.example.onlineMagazin.entity.product.Product;
import lombok.Getter;
import lombok.Setter;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 17.03.2022 0:21
 * Project : onlineMagazin
 */
@Getter
@Setter
public class ImageCreateDto implements Dto {
    private Product product;
    private String image_path;
    private Boolean is_main;

}
