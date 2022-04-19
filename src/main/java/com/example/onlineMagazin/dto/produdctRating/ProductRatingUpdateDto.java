package com.example.onlineMagazin.dto.produdctRating;

import com.example.onlineMagazin.dto.GenericDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRatingUpdateDto extends GenericDto {
    private Long productId;
    private Long ratingTypeId;
    private Long countLike;
}
