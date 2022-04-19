package com.example.onlineMagazin.dto.productComment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCommentNameDto {
    private String username;
    private String image_path;
    private String message;
    private String rating;
}
