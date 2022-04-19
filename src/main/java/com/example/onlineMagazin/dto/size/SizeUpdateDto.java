package com.example.onlineMagazin.dto.size;

import com.example.onlineMagazin.dto.GenericDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SizeUpdateDto extends GenericDto {
    private String code;
    private Integer number;
}
