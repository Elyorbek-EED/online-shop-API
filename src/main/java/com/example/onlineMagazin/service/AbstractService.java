package com.example.onlineMagazin.service;

import com.example.onlineMagazin.mappers.Mapper;
import com.example.onlineMagazin.repository.AbstractRepository;
import com.example.onlineMagazin.validator.Validator;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 14.03.2022 10:24
 * Project : zakovat
 */
public abstract class AbstractService<
        R extends AbstractRepository,
        M extends Mapper,
        V extends Validator> implements BaseService {
    protected final R repository;
    protected final M mapper;
    protected final V validator;

    protected AbstractService(R repository, M mapper, V validator) {
        this.repository = repository;
        this.mapper = mapper;
        this.validator = validator;
    }
}
