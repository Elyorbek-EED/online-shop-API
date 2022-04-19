package com.example.onlineMagazin.dto.product;

import com.example.onlineMagazin.dto.Dto;
import com.example.onlineMagazin.entity.category.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 15.03.2022 20:22
 * Project : onlineMagazin
 */
@Getter
@Setter
@Builder
public class ProductCreateDto implements Dto {
    private Category category;
    private String name;
    private String description;
    private Double price;

}
