package com.example.onlineMagazin.dto.language;

import com.example.onlineMagazin.dto.GenericDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LanguageUpdateDto extends GenericDto {
    private Long id;
    private String name;
    private String code;
}
