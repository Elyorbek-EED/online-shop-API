package com.example.onlineMagazin.service.product;

import com.example.onlineMagazin.dto.productImage.ImageCreateDto;
import com.example.onlineMagazin.dto.productImage.ImageDto;
import com.example.onlineMagazin.dto.productImage.ImagePathDto;
import com.example.onlineMagazin.dto.response.AppErrorDto;
import com.example.onlineMagazin.dto.response.DataDto;
import com.example.onlineMagazin.entity.product.ProductImage;
import com.example.onlineMagazin.mappers.product.ImageMapper;
import com.example.onlineMagazin.repository.product.ImageRepository;
import com.example.onlineMagazin.service.AbstractService;
import com.example.onlineMagazin.validator.product.ImageValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService extends AbstractService<
        ImageRepository,
        ImageMapper,
        ImageValidator> {
    protected ImageService(ImageRepository repository, ImageMapper mapper, ImageValidator validator) {
        super(repository, mapper, validator);
    }

    public ResponseEntity<DataDto<List<ImageDto>>> getAll(Long productId) {
        List<ProductImage> images = repository.findAllByProductId(productId);
        return new ResponseEntity<>(new DataDto<>(mapper.toDto(images), (long) images.size()), HttpStatus.OK);
    }

    public ResponseEntity<ImageDto> get(Long id) {
        Optional<ProductImage> imageOptional = repository.findByIdAndDeletedFalse(id);
        if (imageOptional.isEmpty())
            return new ResponseEntity<>(null, HttpStatus.OK);
        return new ResponseEntity<>(mapper.toDto(imageOptional.get()), HttpStatus.OK);
    }

    public ResponseEntity<ImageDto> getByMain(Long id) {
        List<ProductImage> all = repository.findAll();
        for (ProductImage productImage : all) {
            if (productImage.getProduct().getId().equals(id)) {
                if (productImage.getIs_main()) {
                    return new ResponseEntity<>(mapper.toDto(productImage), HttpStatus.OK);
                }
            }
        }
        return null;
    }

    public List<ImagePathDto> getAllById(Long id) {
        List<ImagePathDto> imagePathDtos = new ArrayList<>();
        List<ProductImage> all = repository.findAll();
        for (ProductImage productImage : all) {
            if (productImage.getProduct().getId().equals(id)) {
                ImagePathDto imagePathDto = new ImagePathDto();
                imagePathDto.setImage_path(productImage.getImage_path());
                imagePathDtos.add(imagePathDto);
            }
        }
        return imagePathDtos;
    }

    public ResponseEntity<DataDto<Boolean>> delete(Long id) {
        Optional<ProductImage> imageOptional = repository.findByIdAndDeletedFalse(id);
        if (imageOptional.isEmpty())
            return new ResponseEntity<>(new DataDto<>(AppErrorDto
                    .builder()
                    .status(HttpStatus.NOT_FOUND)
                    .build()), HttpStatus.OK);
        repository.delete(imageOptional.get());
        return new ResponseEntity<>(new DataDto<>(true), HttpStatus.OK);
    }

    public ResponseEntity<DataDto<Boolean>> create(ImageCreateDto dto) {
        ProductImage image = mapper.fromCreateDto(dto);
        repository.save(image);
        return new ResponseEntity<>(new DataDto<>(true), HttpStatus.OK);
    }

}
