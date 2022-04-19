package com.example.onlineMagazin.dto.size;

import com.example.onlineMagazin.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SizeCreateDto implements Dto {
    private String code;
    private Integer number;
}
