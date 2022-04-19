package com.example.onlineMagazin.controller.productLike;

import com.example.onlineMagazin.controller.AbstractController;
import com.example.onlineMagazin.dto.language.LanguageCreateDto;
import com.example.onlineMagazin.dto.product.ProductDto;
import com.example.onlineMagazin.dto.product.ProductOnlyDto;
import com.example.onlineMagazin.dto.productLike.ProductLikeCreateDto;
import com.example.onlineMagazin.dto.productLike.ProductLikeDto;
import com.example.onlineMagazin.entity.language.Language;
import com.example.onlineMagazin.entity.product.Product;
import com.example.onlineMagazin.entity.product.ProductLike;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.productLike.ProductLikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductLikeController extends AbstractController<ProductLikeService> {

    public ProductLikeController(ProductLikeService service) {
        super(service);
    }

    @RequestMapping(value = PATH + "/product/like/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ProductOnlyDto>> getAllProductByUserId(@PathVariable Long id) {
        return service.getAllProductByUserId(id);
    }

    @RequestMapping(value = PATH + "/product/like/list", method = RequestMethod.GET)
    public ResponseEntity<List<ProductLike>> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = PATH + "/product/like/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductLike> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = PATH + "/product/like/{ProId}/{UserId}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable Long ProId, @PathVariable Long UserId) {
        return service.delete(ProId, UserId);
    }

    @RequestMapping(value = PATH + "/product/like/create", method = RequestMethod.POST)
    public ResponseEntity<Response> create(@RequestBody ProductLikeCreateDto productLikeCreateDto) {
        return service.create(productLikeCreateDto);
    }
}
