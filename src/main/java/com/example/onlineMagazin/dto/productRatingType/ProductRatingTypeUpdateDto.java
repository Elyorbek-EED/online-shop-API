package com.example.onlineMagazin.dto.productRatingType;

import com.example.onlineMagazin.dto.GenericDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRatingTypeUpdateDto extends GenericDto {
    private String name;
    private String code;
}
