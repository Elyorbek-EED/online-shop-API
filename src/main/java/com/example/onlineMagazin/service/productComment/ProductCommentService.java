package com.example.onlineMagazin.service.productComment;

import com.example.onlineMagazin.dto.productComment.ProductCommentCreateDto;
import com.example.onlineMagazin.dto.productComment.ProductCommentNameDto;
import com.example.onlineMagazin.entity.product.ProductComment;
import com.example.onlineMagazin.mappers.productComment.ProductCommentMapper;
import com.example.onlineMagazin.repository.ProductComment.ProductCommentRepository;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.AbstractService;
import com.example.onlineMagazin.service.auth.AuthUserService;
import com.example.onlineMagazin.service.product.ProductService;
import com.example.onlineMagazin.validator.productComment.ProductCommentValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCommentService extends AbstractService<ProductCommentRepository, ProductCommentMapper, ProductCommentValidator> {

    private final ProductService productService;
    private final AuthUserService authUserService;

    protected ProductCommentService(ProductCommentRepository repository, ProductCommentMapper mapper, ProductCommentValidator validator, ProductService productService, AuthUserService authUserService) {
        super(repository, mapper, validator);
        this.productService = productService;
        this.authUserService = authUserService;
    }

    public List<ProductCommentNameDto> getAllById(Long id) {
        List<ProductCommentNameDto> list = new ArrayList<>();
        List<ProductComment> all = repository.findAll();
        for (ProductComment productComment : all) {
            if (productComment.getProduct().getId().equals(id)) {
                ProductCommentNameDto productCommentNameDto = new ProductCommentNameDto();
                productCommentNameDto.setUsername(productComment.getAuthUser().getUsername());
                productCommentNameDto.setMessage(productComment.getMessage());
                productCommentNameDto.setRating(productComment.getRating());
                list.add(productCommentNameDto);
            }
        }
        return list;
    }

    public ResponseEntity<List<ProductComment>> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<ProductComment> getById(Long id) {
        return new ResponseEntity<>(repository.getById(id), HttpStatus.OK);
    }

    public ResponseEntity<Response> delete(Long id) {
        repository.delete(repository.getById(id));
        return new ResponseEntity<>(new Response("Successfully deleted Product Comment", HttpStatus.OK.value()), HttpStatus.OK);
    }

    public ResponseEntity<Response> create(ProductCommentCreateDto productCommentDto) {
        ProductComment productComment = mapper.fromCreateDto(productCommentDto);
        productComment.setProduct(productService.getById(productCommentDto.getProductId()));
        productComment.setAuthUser(authUserService.getById(productCommentDto.getUserId()));
        productComment.setRating(productCommentDto.getRating());
        repository.save(productComment);
        return new ResponseEntity<>(new Response("Successfully created Product Comment", HttpStatus.OK.value()), HttpStatus.OK);
    }

}
