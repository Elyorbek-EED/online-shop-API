package com.example.onlineMagazin.dto.productImage;

import com.example.onlineMagazin.dto.GenericDto;
import com.example.onlineMagazin.entity.product.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 17.03.2022 0:21
 * Project : onlineMagazin
 */
@Getter
@Setter
public class ImageDto extends GenericDto {
    private Product product;
    private String image_path;
    private Boolean is_main;


    @Builder(builderMethodName = "childBuilder")
    public ImageDto(Long id, Product product, String image_path, Boolean is_main) {
        super(id);
        this.product = product;
        this.image_path = image_path;
        this.is_main = is_main;
    }
}
