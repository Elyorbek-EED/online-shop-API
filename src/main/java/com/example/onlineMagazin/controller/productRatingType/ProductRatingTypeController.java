package com.example.onlineMagazin.controller.productRatingType;

import com.example.onlineMagazin.controller.AbstractController;
import com.example.onlineMagazin.dto.productPrice.ProductPriceCreateDto;
import com.example.onlineMagazin.dto.productPrice.ProductPriceUpdateDto;
import com.example.onlineMagazin.dto.productRatingType.ProductRatingTypeCreateDto;
import com.example.onlineMagazin.dto.productRatingType.ProductRatingTypeUpdateDto;
import com.example.onlineMagazin.entity.productPrice.ProductPrice;
import com.example.onlineMagazin.entity.productRating.ProductRatingType;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.productRatingType.ProductRatingTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRatingTypeController extends AbstractController<ProductRatingTypeService> {

    public ProductRatingTypeController(ProductRatingTypeService service) {
        super(service);
    }

    @RequestMapping(value = PATH + "/product/rating/type/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Response> update(@RequestBody ProductRatingTypeUpdateDto productRatingTypeUpdateDto, @PathVariable Long id) {
        return service.update(productRatingTypeUpdateDto, id);
    }

    @RequestMapping(value = PATH + "/product/rating/type/list", method = RequestMethod.GET)
    public ResponseEntity<List<ProductRatingType>> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = PATH + "/product/rating/type/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductRatingType> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = PATH + "/product/rating/type/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = PATH + "/product/rating/type/create", method = RequestMethod.POST)
    public ResponseEntity<Response> create(@RequestBody ProductRatingTypeCreateDto productRatingTypeCreateDto) {
        return service.create(productRatingTypeCreateDto);
    }
}
