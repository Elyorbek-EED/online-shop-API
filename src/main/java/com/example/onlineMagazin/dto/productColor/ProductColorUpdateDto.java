package com.example.onlineMagazin.dto.productColor;

import com.example.onlineMagazin.dto.GenericDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductColorUpdateDto extends GenericDto {
    private Long id;
    private Long productId;
    private Long colorId;
}
