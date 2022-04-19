package com.example.onlineMagazin.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilterDto {
    private Integer size;
    private Integer page;
    private Long sortById;
    private Long priceId;
    private Long colorId;
}
