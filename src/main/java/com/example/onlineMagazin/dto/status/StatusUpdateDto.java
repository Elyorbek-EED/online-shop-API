package com.example.onlineMagazin.dto.status;

import com.example.onlineMagazin.dto.GenericDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatusUpdateDto extends GenericDto {
    private Long id;
    private String name;
    private String code;
}
