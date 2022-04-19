package com.example.onlineMagazin.dto.category;

import com.example.onlineMagazin.dto.Dto;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCreateDto implements Dto {
    private String name;
}
