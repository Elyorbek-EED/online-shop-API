package com.example.onlineMagazin.dto.role;

import com.example.onlineMagazin.dto.GenericDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleUpdateDto extends GenericDto {
    private Long id;
    private String name;
    private String code;
}
