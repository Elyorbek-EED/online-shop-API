package com.example.onlineMagazin.dto.productPrice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPriceDto {
    private Long id;
    private Long productId;
    private Double usd;
    private Double rub;
    private Double uzs;
}
