package com.example.onlineMagazin.dto.status;

import com.example.onlineMagazin.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatusCreateDto implements Dto {
    private String name;
    private String code;
}
