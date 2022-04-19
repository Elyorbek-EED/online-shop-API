package com.example.onlineMagazin.controller.product;

import com.example.onlineMagazin.controller.AbstractController;
import com.example.onlineMagazin.criteria.product.ProductCriteria;
import com.example.onlineMagazin.dto.filter.FilterDto;
import com.example.onlineMagazin.dto.product.ProductCreateDto;
import com.example.onlineMagazin.dto.product.ProductDto;
import com.example.onlineMagazin.dto.product.ProductFullDto;
import com.example.onlineMagazin.dto.product.ProductUpdateDto;
import com.example.onlineMagazin.dto.response.DataDto;
import com.example.onlineMagazin.service.product.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;


@RestController
public class ProductController extends AbstractController<ProductService> {

    public ProductController(ProductService service) {
        super(service);
    }

    @RequestMapping(value = PATH + "/product", method = RequestMethod.GET)
    public ResponseEntity<List<ProductDto>> getAll(@Valid ProductCriteria criteria) {
        return new ResponseEntity<>(Objects.requireNonNull(service.getAll(criteria).getBody()).getData(), HttpStatus.OK);
    }

    @RequestMapping(value = PATH + "/product/filter", method = RequestMethod.POST)
        public ResponseEntity<List<ProductDto>> getAllWithFilter(@RequestBody FilterDto filterDto) {
        return service.getAllWithFilter(filterDto);
    }

    @RequestMapping(value = PATH + "/product/search/{word}", method = RequestMethod.GET)
    public ResponseEntity<List<ProductDto>> getAllWithSearch(@PathVariable String word) {
        return service.getAllWithSearch(word);
    }

    @RequestMapping(value = PATH + "/product/{id}", method = RequestMethod.GET)
    public ResponseEntity<DataDto<ProductDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @RequestMapping(value = PATH + "/product/full/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductFullDto> getFull(@PathVariable Long id) {
        return service.getFull(id);
    }

    @RequestMapping(value = PATH + "/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DataDto<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = PATH + "/product/update", method = RequestMethod.PUT)
    public ResponseEntity<DataDto<Boolean>> update(@RequestBody ProductUpdateDto dto) {
        return service.update(dto);
    }

    @RequestMapping(value = PATH + "/product/create", method = RequestMethod.POST)
    public ResponseEntity<DataDto<Boolean>> create(@RequestBody ProductCreateDto dto) {
        return service.create(dto);
    }

}
