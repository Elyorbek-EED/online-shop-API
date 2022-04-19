package com.example.onlineMagazin.service.productRating;

import com.example.onlineMagazin.dto.productPrice.ProductPriceCreateDto;
import com.example.onlineMagazin.dto.productPrice.ProductPriceUpdateDto;
import com.example.onlineMagazin.dto.produdctRating.ProductRatingCreateDto;
import com.example.onlineMagazin.dto.produdctRating.ProductRatingUpdateDto;
import com.example.onlineMagazin.entity.productPrice.ProductPrice;
import com.example.onlineMagazin.entity.productRating.ProductRating;
import com.example.onlineMagazin.mappers.productRating.ProductRatingMapper;
import com.example.onlineMagazin.repository.productRating.ProductRatingRepository;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.AbstractService;
import com.example.onlineMagazin.validator.productRating.ProductRatingValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductRatingService extends AbstractService<ProductRatingRepository, ProductRatingMapper, ProductRatingValidator> {

    protected ProductRatingService(ProductRatingRepository repository, ProductRatingMapper mapper, ProductRatingValidator validator) {
        super(repository, mapper, validator);
    }

    public ResponseEntity<List<ProductRating>> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<ProductRating> getById(Long id) {
        return new ResponseEntity<>(repository.getById(id), HttpStatus.OK);
    }

    public ResponseEntity<Response> delete(Long id) {
        repository.delete(repository.getById(id));
        return new ResponseEntity<>(new Response("Successfully deleted Product Rating", HttpStatus.OK.value()), HttpStatus.OK);
    }

    public ResponseEntity<Response> create(ProductRatingCreateDto productRatingCreateDto) {
        ProductRating productRating = mapper.fromCreateDto(productRatingCreateDto);
        productRating.setCountLike(0L);
        repository.save(productRating);
        return new ResponseEntity<>(new Response("Successfully created Product Rating", HttpStatus.OK.value()), HttpStatus.OK);
    }

    public ResponseEntity<Response> update(ProductRatingUpdateDto productRatingUpdateDto, Long id) {
        Optional<ProductRating> byId = repository.findById(id);
        ProductRating productRating = byId.get();
        productRating.setCountLike(productRatingUpdateDto.getCountLike());
        repository.save(productRating);
        return new ResponseEntity<>(new Response("Successfully updated Product Rating", HttpStatus.OK.value()), HttpStatus.OK);
    }

    public Boolean checkWithPopularity(Long id) {
        ProductRating rating = repository.getById(id);
        return rating.getProductRatingType().getId() == 1;
    }
    public Boolean checkWithAvg(Long id) {
        ProductRating rating = repository.getById(id);
        return rating.getProductRatingType().getId() == 2;
    }
}
