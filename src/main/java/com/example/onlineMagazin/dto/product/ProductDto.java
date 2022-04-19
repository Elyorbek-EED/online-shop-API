package com.example.onlineMagazin.dto.product;

import com.example.onlineMagazin.dto.GenericDto;
import com.example.onlineMagazin.entity.category.Category;
import com.example.onlineMagazin.entity.status.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 15.03.2022 20:08
 * Project : onlineMagazin
 */
@Getter
@Setter
public class ProductDto extends GenericDto {
    private Category category;
    private String name;
    private String description;
    private Double price;
    private Boolean is_new;
    private Status status;
    private String image_path;
//    private String created_by;
//    private String created_at;

    @Builder(builderMethodName = "childrenBuilder")
    public ProductDto(Long id, Category category, String name,
                      String description, Double price, Boolean is_new,
                      Status status) {
        super(id);
        this.category = category;
        this.name = name;
        this.description = description;
        this.price = price;
        this.is_new = is_new;
        this.status = status;
    }
}
