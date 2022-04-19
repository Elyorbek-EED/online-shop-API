package com.example.onlineMagazin.controller.productRating;

import com.example.onlineMagazin.controller.AbstractController;
import com.example.onlineMagazin.dto.productPrice.ProductPriceCreateDto;
import com.example.onlineMagazin.dto.productPrice.ProductPriceUpdateDto;
import com.example.onlineMagazin.dto.productRatingType.ProductRatingTypeUpdateDto;
import com.example.onlineMagazin.dto.produdctRating.ProductRatingCreateDto;
import com.example.onlineMagazin.dto.produdctRating.ProductRatingUpdateDto;
import com.example.onlineMagazin.entity.productPrice.ProductPrice;
import com.example.onlineMagazin.entity.productRating.ProductRating;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.productRating.ProductRatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRatingController extends AbstractController<ProductRatingService> {

    public ProductRatingController(ProductRatingService service) {
        super(service);
    }

    @RequestMapping(value = PATH + "/product/rating/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Response> update(@RequestBody ProductRatingUpdateDto productRatingUpdateDto, @PathVariable Long id) {
        return service.update(productRatingUpdateDto, id);
    }

    @RequestMapping(value = PATH + "/product/rating/list", method = RequestMethod.GET)
    public ResponseEntity<List<ProductRating>> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = PATH + "/product/rating/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductRating> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = PATH + "/product/rating/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = PATH + "/product/rating/create", method = RequestMethod.POST)
    public ResponseEntity<Response> create(@RequestBody ProductRatingCreateDto productRatingCreateDto) {
        return service.create(productRatingCreateDto);
    }
}
