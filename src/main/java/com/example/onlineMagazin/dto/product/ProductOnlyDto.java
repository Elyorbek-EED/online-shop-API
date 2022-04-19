package com.example.onlineMagazin.dto.product;

import com.example.onlineMagazin.entity.category.Category;
import com.example.onlineMagazin.entity.status.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductOnlyDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Boolean is_new;
    private String image_path;
}
