package com.example.onlineMagazin.dto.productLike;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductLikeDto {
    private Long userId;
    private Long productId;
}
