package com.example.onlineMagazin.dto.userCart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserCartDto {
    private Long userId;
    private Long productId;
    private Integer count;
    private Boolean accept;
}
