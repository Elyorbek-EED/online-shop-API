package com.example.onlineMagazin.dto.productLike;

import com.example.onlineMagazin.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductLikeCreateDto implements Dto {
    private Long userId;
    private Long productId;
}
