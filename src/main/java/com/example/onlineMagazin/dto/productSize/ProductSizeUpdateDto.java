package com.example.onlineMagazin.dto.productSize;

import com.example.onlineMagazin.dto.GenericDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductSizeUpdateDto extends GenericDto {
    private Long productId;
    private Long SizeId;
}
