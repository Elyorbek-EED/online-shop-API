package com.example.onlineMagazin.dto.category;

import com.example.onlineMagazin.dto.Dto;
import com.example.onlineMagazin.dto.GenericDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CategoryUpdateDto extends GenericDto {
    private Long id;
    private String name;
}
