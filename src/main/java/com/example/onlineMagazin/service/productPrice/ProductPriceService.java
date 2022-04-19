package com.example.onlineMagazin.service.productPrice;

import com.example.onlineMagazin.dto.language.LanguageCreateDto;
import com.example.onlineMagazin.dto.language.LanguageUpdateDto;
import com.example.onlineMagazin.dto.productPrice.ProductPriceCreateDto;
import com.example.onlineMagazin.dto.productPrice.ProductPriceUpdateDto;
import com.example.onlineMagazin.entity.language.Language;
import com.example.onlineMagazin.entity.productPrice.ProductPrice;
import com.example.onlineMagazin.mappers.productPrice.ProductPriceMapper;
import com.example.onlineMagazin.repository.productPrice.ProductPriceRepository;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.AbstractService;
import com.example.onlineMagazin.validator.productPrice.ProductPriceValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductPriceService extends AbstractService<ProductPriceRepository, ProductPriceMapper, ProductPriceValidator> {

    protected ProductPriceService(ProductPriceRepository repository, ProductPriceMapper mapper, ProductPriceValidator validator) {
        super(repository, mapper, validator);
    }

    public ResponseEntity<List<ProductPrice>> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<ProductPrice> getById(Long id) {
        return new ResponseEntity<>(repository.getById(id), HttpStatus.OK);
    }

    public ResponseEntity<Response> delete(Long id) {
        repository.delete(repository.getById(id));
        return new ResponseEntity<>(new Response("Successfully deleted Product Price", HttpStatus.OK.value()), HttpStatus.OK);
    }

    public ResponseEntity<Response> create(ProductPriceCreateDto productPriceCreateDto) {
        ProductPrice productPrice = mapper.fromCreateDto(productPriceCreateDto);
        productPrice.setUsd(Double.valueOf(productPriceCreateDto.getUsd()));
        productPrice.setRub(Double.valueOf(productPriceCreateDto.getRub()));
        productPrice.setUzs(Double.valueOf(productPriceCreateDto.getUzs()));
        repository.save(productPrice);
        return new ResponseEntity<>(new Response("Successfully created Product Price", HttpStatus.OK.value()), HttpStatus.OK);
    }

    public ResponseEntity<Response> update(ProductPriceUpdateDto productPriceUpdateDto, Long id) {
        Optional<ProductPrice> byId = repository.findById(id);
        ProductPrice productPrice = byId.get();
        productPrice.setUzs(Double.valueOf(productPriceUpdateDto.getUzs()));
        productPrice.setUsd(Double.valueOf(productPriceUpdateDto.getUsd()));
        productPrice.setRub(Double.valueOf(productPriceUpdateDto.getRub()));
        productPrice.setUpdatedAt(LocalDateTime.now());
        repository.save(productPrice);
        return new ResponseEntity<>(new Response("Successfully updated Product Price", HttpStatus.OK.value()), HttpStatus.OK);
    }
}
