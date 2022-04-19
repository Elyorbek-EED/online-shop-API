package com.example.onlineMagazin.criteria;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 14.03.2022 10:27
 * Project : zakovat
 */
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenericCriteria {

    private Integer size;
    private Integer page;

    public Integer getPage() {
        if (Objects.isNull(page))
            page = 0;
        return page;
    }

    public Integer getSize() {
        if (Objects.isNull(size))
            size = 10;
        return size;
    }


}
