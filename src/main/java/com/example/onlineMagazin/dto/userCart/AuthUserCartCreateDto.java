package com.example.onlineMagazin.dto.userCart;

import com.example.onlineMagazin.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserCartCreateDto implements Dto {
    private Long userId;
    private Long productId;
    private Integer count;
    private Boolean accept;
}
