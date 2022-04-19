package com.example.onlineMagazin.dto.product;

import com.example.onlineMagazin.dto.GenericDto;
import com.example.onlineMagazin.entity.category.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 15.03.2022 20:25
 * Project : onlineMagazin
 */
@Getter
@Setter
public class ProductUpdateDto extends GenericDto {
    private Category category;
    private String name;
    private String description;
    private Double price;

    @Builder(builderMethodName = "childrenBuilder")
    public ProductUpdateDto(Long id, Category category, String name, String description, Double price) {
        super(id);
        this.category = category;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
