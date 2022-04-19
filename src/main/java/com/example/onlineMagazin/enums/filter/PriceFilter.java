package com.example.onlineMagazin.enums.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PriceFilter {
    ALL(0L),
    ZERO_TO_FIFTY(1L),
    FIFTY_TO_HUNDRED(2L),
    HUNDRED_T0_ONE_HUND_FIFTY(3L),
    ONE_HUND_FIFTY_TO_TWO_HUNDRED(4L),
    TWO_HUNDRED_TO_PLUS(5L);
    private final Long id;
}
