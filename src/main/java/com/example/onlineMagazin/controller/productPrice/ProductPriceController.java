package com.example.onlineMagazin.controller.productPrice;

import com.example.onlineMagazin.controller.AbstractController;
import com.example.onlineMagazin.dto.language.LanguageCreateDto;
import com.example.onlineMagazin.dto.language.LanguageUpdateDto;
import com.example.onlineMagazin.dto.productPrice.ProductPriceCreateDto;
import com.example.onlineMagazin.dto.productPrice.ProductPriceUpdateDto;
import com.example.onlineMagazin.entity.language.Language;
import com.example.onlineMagazin.entity.productPrice.ProductPrice;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.productPrice.ProductPriceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductPriceController extends AbstractController<ProductPriceService> {

    public ProductPriceController(ProductPriceService service) {
        super(service);
    }

    @RequestMapping(value = PATH + "/product/price/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Response> update(@RequestBody ProductPriceUpdateDto productPriceUpdateDto, @PathVariable Long id) {
        return service.update(productPriceUpdateDto, id);
    }

    @RequestMapping(value = PATH + "/product/price/list", method = RequestMethod.GET)
    public ResponseEntity<List<ProductPrice>> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = PATH + "/product/price/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductPrice> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = PATH + "/product/price/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = PATH + "/product/price/create", method = RequestMethod.POST)
    public ResponseEntity<Response> create(@RequestBody ProductPriceCreateDto productPriceCreateDto) {
        return service.create(productPriceCreateDto);
    }
}
