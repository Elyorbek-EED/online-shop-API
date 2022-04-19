package com.example.onlineMagazin.dto.productComment;

import com.example.onlineMagazin.dto.GenericDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCommentUpdateDto extends GenericDto {
    private Long userId;
    private Long productId;
    private String message;
}
