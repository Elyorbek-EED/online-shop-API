package com.example.onlineMagazin.dto.productComment;

import com.example.onlineMagazin.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCommentCreateDto implements Dto {
    private Long userId;
    private Long productId;
    private String message;
    private String rating;
}
