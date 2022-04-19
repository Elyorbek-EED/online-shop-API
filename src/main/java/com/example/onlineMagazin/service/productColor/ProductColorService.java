package com.example.onlineMagazin.service.productColor;

import com.example.onlineMagazin.dto.language.LanguageCreateDto;
import com.example.onlineMagazin.dto.productColor.ProductColorCreateDto;
import com.example.onlineMagazin.dto.productColor.ProductColorNameDto;
import com.example.onlineMagazin.entity.language.Language;
import com.example.onlineMagazin.entity.product.ProductColor;
import com.example.onlineMagazin.mappers.productColor.ProductColorMapper;
import com.example.onlineMagazin.repository.productColor.ProductColorRepository;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.AbstractService;
import com.example.onlineMagazin.validator.productColor.ProductColorValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductColorService extends AbstractService<ProductColorRepository, ProductColorMapper, ProductColorValidator> {

    protected ProductColorService(ProductColorRepository repository, ProductColorMapper mapper, ProductColorValidator validator) {
        super(repository, mapper, validator);
    }

    public ResponseEntity<List<ProductColor>> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<ProductColor> getById(Long id) {
        return new ResponseEntity<>(repository.getById(id), HttpStatus.OK);
    }

    public ResponseEntity<Response> delete(Long id) {
        repository.delete(repository.getById(id));
        return new ResponseEntity<>(new Response("Successfully deleted ProductColor", HttpStatus.OK.value()), HttpStatus.OK);
    }

    public ResponseEntity<Response> create(ProductColorCreateDto colorCreateDto) {
        ProductColor productColor = mapper.fromCreateDto(colorCreateDto);
        repository.save(productColor);
        return new ResponseEntity<>(new Response("Successfully created ProductColor", HttpStatus.OK.value()), HttpStatus.OK);
    }

    public List<ProductColorNameDto> getAllById(Long id) {
        List<ProductColorNameDto> colors = new ArrayList<>();
        List<ProductColor> all = repository.findAll();
        for (ProductColor productColor : all) {
            if (productColor.getProduct().getId().equals(id)) {
                ProductColorNameDto productColorNameDto = new ProductColorNameDto();
                productColorNameDto.setName(productColor.getColor().getName());
                productColorNameDto.setId(productColor.getColor().getId());
                colors.add(productColorNameDto);
            }
        }
        return colors;
    }

    public Boolean checkHaveColor(Long productId, Long colorId) {
        for (ProductColor productColor : repository.findAll()) {
            if (productColor.getProduct().getId().equals(productId)) {
                if (productColor.getColor().getId().equals(colorId)) {
                    return true;
                }
            }
        }
        return false;
    }
}
