package com.example.onlineMagazin.criteria.product;

import com.example.onlineMagazin.criteria.GenericCriteria;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductCriteria extends GenericCriteria {

    public ProductCriteria(Integer size, Integer page) {
        super(size, page);
    }
}
