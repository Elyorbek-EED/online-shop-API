package com.example.onlineMagazin.service.productLike;

import com.example.onlineMagazin.dto.product.ProductOnlyDto;
import com.example.onlineMagazin.dto.productLike.ProductLikeCreateDto;
import com.example.onlineMagazin.entity.product.ProductLike;
import com.example.onlineMagazin.mappers.productLike.ProductLikeMapper;
import com.example.onlineMagazin.repository.productLike.ProductLikeRepository;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.AbstractService;
import com.example.onlineMagazin.service.auth.AuthUserService;
import com.example.onlineMagazin.service.product.ImageService;
import com.example.onlineMagazin.service.product.ProductService;
import com.example.onlineMagazin.validator.productLike.ProductLikeValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductLikeService extends AbstractService<ProductLikeRepository, ProductLikeMapper, ProductLikeValidator> {

    private final ProductService productService;
    private final ImageService imageService;
    private final AuthUserService userService;

    protected ProductLikeService(ProductLikeRepository repository, ProductLikeMapper mapper, ProductLikeValidator validator, ProductService productService, ImageService imageService, AuthUserService userService) {
        super(repository, mapper, validator);
        this.productService = productService;
        this.imageService = imageService;
        this.userService = userService;
    }

    public ResponseEntity<List<ProductOnlyDto>> getAllProductByUserId(Long id) {
        List<ProductOnlyDto> onlyDtos = new ArrayList<>();
        List<ProductLike> all = repository.findAll();
        for (ProductLike productLike : all) {
            if (productLike.getAuthUser().getId().equals(id)) {
                ProductOnlyDto productOnlyDto = mapper.fromProductOnlyDto(productLike.getProduct());
                productOnlyDto.setImage_path(imageService.getByMain(productLike.getProduct().getId()).getBody().getImage_path());
                onlyDtos.add(productOnlyDto);
            }
        }
        return new ResponseEntity<>(onlyDtos, HttpStatus.OK);
    }

    public ResponseEntity<List<ProductLike>> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<ProductLike> getById(Long id) {
        return new ResponseEntity<>(repository.getById(id), HttpStatus.OK);
    }

    public ResponseEntity<Response> delete(Long id, Long userId) {
        repository.deleteWith(id, userId);
        return new ResponseEntity<>(new Response("Successfully deleted Product Like", HttpStatus.OK.value()), HttpStatus.OK);
    }

    public ResponseEntity<Response> create(ProductLikeCreateDto productLikeCreateDto) {
        List<ProductLike> all = repository.findAll();
        for (ProductLike productLike : all) {
            if (productLike.getAuthUser().getId().equals(productLikeCreateDto.getUserId())) {
                if (productLike.getProduct().getId().equals(productLikeCreateDto.getProductId())) {
                    return new ResponseEntity<>(new Response("Already Created Product Like", HttpStatus.OK.value()), HttpStatus.OK);
                }
            }
        }
        ProductLike productLike = new ProductLike();
        productLike.setProduct(productService.getById(productLikeCreateDto.getProductId()));
        productLike.setAuthUser(userService.getById(productLikeCreateDto.getUserId()));
        repository.save(productLike);
        return new ResponseEntity<>(new Response("Successfully created Product Like", HttpStatus.OK.value()), HttpStatus.OK);
    }
}
