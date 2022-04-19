package com.example.onlineMagazin.dto.productComment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCommentDto {
    private Long userId;
    private Long productId;
    private String message;
    private String rating;
}
