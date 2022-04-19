package com.example.onlineMagazin.dto;

import lombok.*;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 14.03.2022 10:29
 * Project : zakovat
 */
@Getter
@Setter
@NoArgsConstructor
public class GenericDto implements Dto{

    private Long id;

    public GenericDto(Long id) {
        this.id = id;
    }

}
