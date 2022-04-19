package com.example.onlineMagazin.controller.productComment;

import com.example.onlineMagazin.controller.AbstractController;
import com.example.onlineMagazin.dto.productComment.ProductCommentCreateDto;
import com.example.onlineMagazin.entity.product.ProductComment;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.productComment.ProductCommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductCommentController extends AbstractController<ProductCommentService> {

    public ProductCommentController(ProductCommentService service) {
        super(service);
    }

    @RequestMapping(value = PATH + "/product/comment/list", method = RequestMethod.GET)
    public ResponseEntity<List<ProductComment>> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = PATH + "/product/comment/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductComment> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = PATH + "/product/comment/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = PATH + "/product/comment/create", method = RequestMethod.POST)
    public ResponseEntity<Response> create(@RequestBody ProductCommentCreateDto productCommentDto) {
        return service.create(productCommentDto);
    }
}
