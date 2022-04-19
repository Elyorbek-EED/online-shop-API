package com.example.onlineMagazin.service.productSize;

import com.example.onlineMagazin.dto.productLike.ProductLikeCreateDto;
import com.example.onlineMagazin.dto.productSize.ProductSizeCreateDto;
import com.example.onlineMagazin.dto.productSize.ProductSizeNameDto;
import com.example.onlineMagazin.entity.product.ProductLike;
import com.example.onlineMagazin.entity.product.ProductSize;
import com.example.onlineMagazin.mappers.productSize.ProductSizeMapper;
import com.example.onlineMagazin.repository.productSize.ProductSizeRepository;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.AbstractService;
import com.example.onlineMagazin.validator.productSize.ProductSizeValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductSizeService extends AbstractService<ProductSizeRepository, ProductSizeMapper, ProductSizeValidator> {

    protected ProductSizeService(ProductSizeRepository repository, ProductSizeMapper mapper, ProductSizeValidator validator) {
        super(repository, mapper, validator);
    }

    public List<ProductSizeNameDto> getAllById(Long id) {
        List<ProductSizeNameDto> productSizes = new ArrayList<>();
        List<ProductSize> sizes = repository.findAll();
        for (ProductSize size : sizes) {
            if (size.getProduct().getId().equals(id)) {
                ProductSizeNameDto productSizeNameDto = new ProductSizeNameDto();
                productSizeNameDto.setCode(size.getSize().getCode());
                productSizeNameDto.setId(size.getSize().getId());
                productSizes.add(productSizeNameDto);
            }
        }
        return productSizes;
    }

    public ResponseEntity<List<ProductSize>> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<ProductSize> getById(Long id) {
        return new ResponseEntity<>(repository.getById(id), HttpStatus.OK);
    }

    public ResponseEntity<Response> delete(Long id) {
        repository.delete(repository.getById(id));
        return new ResponseEntity<>(new Response("Successfully deleted Product Size", HttpStatus.OK.value()), HttpStatus.OK);
    }

    public ResponseEntity<Response> create(ProductSizeCreateDto productSizeCreateDto) {
        ProductSize size = mapper.fromCreateDto(productSizeCreateDto);
        repository.save(size);
        return new ResponseEntity<>(new Response("Successfully created Product Size", HttpStatus.OK.value()), HttpStatus.OK);
    }
}
