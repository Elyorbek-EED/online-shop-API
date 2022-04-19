package com.example.onlineMagazin.dto.productPrice;

import com.example.onlineMagazin.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPriceCreateDto implements Dto {
    private Long productId;
    private Long usd;
    private Long rub;
    private Long uzs;
}
