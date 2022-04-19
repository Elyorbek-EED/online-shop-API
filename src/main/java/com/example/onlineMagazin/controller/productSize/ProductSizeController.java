package com.example.onlineMagazin.controller.productSize;

import com.example.onlineMagazin.controller.AbstractController;
import com.example.onlineMagazin.dto.productLike.ProductLikeCreateDto;
import com.example.onlineMagazin.dto.productSize.ProductSizeCreateDto;
import com.example.onlineMagazin.entity.product.ProductLike;
import com.example.onlineMagazin.entity.product.ProductSize;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.productSize.ProductSizeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductSizeController extends AbstractController<ProductSizeService> {

    public ProductSizeController(ProductSizeService service) {
        super(service);
    }

    @RequestMapping(value = PATH + "/product/size/list", method = RequestMethod.GET)
    public ResponseEntity<List<ProductSize>> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = PATH + "/product/size/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductSize> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = PATH + "/product/size/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = PATH + "/product/size/create", method = RequestMethod.POST)
    public ResponseEntity<Response> create(@RequestBody ProductSizeCreateDto productSizeCreateDto) {
        return service.create(productSizeCreateDto);
    }
}
