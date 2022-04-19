package com.example.onlineMagazin.controller;

import com.example.onlineMagazin.service.BaseService;
import lombok.RequiredArgsConstructor;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 14.03.2022 10:23
 * Project : zakovat
 */
@RequiredArgsConstructor
public abstract class AbstractController <S extends BaseService>{

    protected final S service;
    protected final String API = "/api";
    protected final String VERSION = "/v1";
    protected final String PATH = API + VERSION;
}
