package com.example.onlineMagazin.dto.productSize;

import com.example.onlineMagazin.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductSizeCreateDto implements Dto {
    private Long productId;
    private Long sizeId;
}
