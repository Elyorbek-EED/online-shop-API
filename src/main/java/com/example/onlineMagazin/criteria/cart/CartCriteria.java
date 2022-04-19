package com.example.onlineMagazin.criteria.cart;

import com.example.onlineMagazin.criteria.GenericCriteria;
import lombok.Getter;
import lombok.Setter;

/**
 * created by Elyor Ergashov
 *
 * @Author : elyor
 * @Date : 07/04/22
 * @Project : online-shop-API
 */

@Getter
@Setter
public class CartCriteria extends GenericCriteria {
    public CartCriteria(Integer size, Integer page) {
        super(size, page);
    }}
