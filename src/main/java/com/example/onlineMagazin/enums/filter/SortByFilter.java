package com.example.onlineMagazin.enums.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SortByFilter {
    DEFAULT(0L),
    POPULARITY(1L),
    AVERAGE_RATING(2L),
    NEWNESS(3L),
    PRICE_LOW_TO_HIGH(4L),
    PRICE_HIGH_TO_LOW(5L);
    private final Long id;
}
