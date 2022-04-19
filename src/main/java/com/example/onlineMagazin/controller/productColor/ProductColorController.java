package com.example.onlineMagazin.controller.productColor;

import com.example.onlineMagazin.controller.AbstractController;
import com.example.onlineMagazin.dto.productColor.ProductColorCreateDto;
import com.example.onlineMagazin.entity.product.ProductColor;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.productColor.ProductColorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductColorController extends AbstractController<ProductColorService> {

    public ProductColorController(ProductColorService service) {
        super(service);
    }

    @RequestMapping(value = PATH + "/product/color/list", method = RequestMethod.GET)
    public ResponseEntity<List<ProductColor>> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = PATH + "/product/color/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductColor> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = PATH + "/product/color/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = PATH + "/product/color/create", method = RequestMethod.POST)
    public ResponseEntity<Response> create(@RequestBody ProductColorCreateDto colorCreateDto) {
        return service.create(colorCreateDto);
    }
}
