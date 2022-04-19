package com.example.onlineMagazin.service.productRatingType;

import com.example.onlineMagazin.dto.productRatingType.ProductRatingTypeCreateDto;
import com.example.onlineMagazin.dto.productRatingType.ProductRatingTypeUpdateDto;
import com.example.onlineMagazin.dto.produdctRating.ProductRatingCreateDto;
import com.example.onlineMagazin.dto.produdctRating.ProductRatingUpdateDto;
import com.example.onlineMagazin.entity.productRating.ProductRating;
import com.example.onlineMagazin.entity.productRating.ProductRatingType;
import com.example.onlineMagazin.mappers.productRatingType.ProductRatingTypeMapper;
import com.example.onlineMagazin.repository.productRatingType.ProductRatingTypeRepository;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.AbstractService;
import com.example.onlineMagazin.validator.productRatingType.ProductRatingTypeValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductRatingTypeService extends AbstractService<ProductRatingTypeRepository, ProductRatingTypeMapper, ProductRatingTypeValidator> {

    protected ProductRatingTypeService(ProductRatingTypeRepository repository, ProductRatingTypeMapper mapper, ProductRatingTypeValidator validator) {
        super(repository, mapper, validator);
    }

    public ResponseEntity<List<ProductRatingType>> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<ProductRatingType> getById(Long id) {
        return new ResponseEntity<>(repository.getById(id), HttpStatus.OK);
    }

    public ResponseEntity<Response> delete(Long id) {
        repository.delete(repository.getById(id));
        return new ResponseEntity<>(new Response("Successfully deleted Product Rating Type", HttpStatus.OK.value()), HttpStatus.OK);
    }

    public ResponseEntity<Response> create(ProductRatingTypeCreateDto productRatingTypeCreateDto) {
        ProductRatingType productRatingType = mapper.fromCreateDto(productRatingTypeCreateDto);
        repository.save(productRatingType);
        return new ResponseEntity<>(new Response("Successfully created Product Rating Type", HttpStatus.OK.value()), HttpStatus.OK);
    }

    public ResponseEntity<Response> update(ProductRatingTypeUpdateDto productRatingTypeUpdateDto, Long id) {
        Optional<ProductRatingType> byId = repository.findById(id);
        ProductRatingType productRatingType = byId.get();
        productRatingType.setCode(productRatingTypeUpdateDto.getCode());
        productRatingType.setName(productRatingTypeUpdateDto.getName());
        repository.save(productRatingType);
        return new ResponseEntity<>(new Response("Successfully updated Product Rating Type", HttpStatus.OK.value()), HttpStatus.OK);
    }
}
