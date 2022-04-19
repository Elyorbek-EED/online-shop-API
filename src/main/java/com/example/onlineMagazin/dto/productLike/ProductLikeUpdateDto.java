package com.example.onlineMagazin.dto.productLike;

import com.example.onlineMagazin.dto.GenericDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductLikeUpdateDto extends GenericDto {
    private Long userId;
    private Long productId;
}
