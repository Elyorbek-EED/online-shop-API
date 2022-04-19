package com.example.onlineMagazin.service.product;

import com.example.onlineMagazin.criteria.product.ProductCriteria;
import com.example.onlineMagazin.dto.filter.FilterDto;
import com.example.onlineMagazin.dto.product.ProductCreateDto;
import com.example.onlineMagazin.dto.product.ProductDto;
import com.example.onlineMagazin.dto.product.ProductFullDto;
import com.example.onlineMagazin.dto.product.ProductUpdateDto;
import com.example.onlineMagazin.dto.response.AppErrorDto;
import com.example.onlineMagazin.dto.response.DataDto;
import com.example.onlineMagazin.entity.product.Product;
import com.example.onlineMagazin.entity.status.Status;
import com.example.onlineMagazin.mappers.product.ProductMapper;
import com.example.onlineMagazin.repository.product.ProductRepository;
import com.example.onlineMagazin.service.AbstractService;
import com.example.onlineMagazin.service.productColor.ProductColorService;
import com.example.onlineMagazin.service.productComment.ProductCommentService;
import com.example.onlineMagazin.service.productRating.ProductRatingService;
import com.example.onlineMagazin.service.productSize.ProductSizeService;
import com.example.onlineMagazin.validator.product.ProductValidator;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService extends AbstractService<
        ProductRepository,
        ProductMapper,
        ProductValidator> {

    private final EntityManager entityManager;
    private final ImageService imageService;
    private final ProductColorService productColorService;
    private final ProductSizeService productSizeService;
    private final ProductCommentService commentService;
    private final ProductRatingService productRatingService;

    protected ProductService(ProductRepository repository, ProductMapper mapper, ProductValidator validator, EntityManager entityManager, ImageService imageService, ProductColorService productColorService, ProductSizeService productSizeService, @Lazy ProductCommentService commentService, ProductRatingService productRatingService) {
        super(repository, mapper, validator);
        this.entityManager = entityManager;
        this.imageService = imageService;
        this.productColorService = productColorService;
        this.productSizeService = productSizeService;
        this.commentService = commentService;
        this.productRatingService = productRatingService;
    }


    public ResponseEntity<DataDto<List<ProductDto>>> getAll(ProductCriteria criteria) {
        Pageable request = PageRequest.of(criteria.getPage(), criteria.getSize());
//        ProductSpecification specification = new ProductSpecification(new SearchCriteria("price", ">", "35"));
        List<Product> products = repository.findAllByDeletedFalse(request);
        List<ProductDto> productDtos = mapper.toDto(products);
        for (ProductDto productDto : productDtos) {
            productDto.setImage_path(imageService.getByMain(productDto.getId()).getBody().getImage_path());
        }
        return new ResponseEntity<>(new DataDto<>(productDtos, (long) products.size()), HttpStatus.OK);
    }

    public Product getById(Long id) {
        return repository.getById(id);
    }

    public ResponseEntity<ProductFullDto> getFull(Long id) {
        Optional<Product> product = repository.findByIdAndDeletedFalse(id);
        ProductFullDto productFullDto = new ProductFullDto();
        productFullDto.setId(product.get().getId());
        productFullDto.setName(product.get().getName());
        productFullDto.setDescription(product.get().getDescription());
        productFullDto.setPrice(product.get().getPrice());
        productFullDto.setIs_new(product.get().getIs_new());
        productFullDto.setColors(productColorService.getAllById(product.get().getId()));
        productFullDto.setImages(imageService.getAllById(product.get().getId()));
        productFullDto.setSizes(productSizeService.getAllById(product.get().getId()));
        productFullDto.setComments(commentService.getAllById(product.get().getId()));
        return new ResponseEntity<>(productFullDto, HttpStatus.OK);
    }

    public ResponseEntity<DataDto<ProductDto>> get(Long id) {
        Optional<Product> productOptional = repository.findByIdAndDeletedFalse(id);
        if (productOptional.isEmpty())
            return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder().build()), HttpStatus.OK);
        return new ResponseEntity<>(new DataDto<>(mapper.toDto(productOptional.get())), HttpStatus.OK);
    }

    public ResponseEntity<DataDto<Boolean>> delete(Long id) {
        Optional<Product> productOptional = repository.findByIdAndDeletedFalse(id);
        if (productOptional.isEmpty())
            return new ResponseEntity<>(new DataDto<>(AppErrorDto
                    .builder()
                    .status(HttpStatus.NOT_FOUND)
                    .build()), HttpStatus.OK);
        repository.delete(productOptional.get());
        return new ResponseEntity<>(new DataDto<>(true), HttpStatus.OK);
    }

    public ResponseEntity<DataDto<Boolean>> update(ProductUpdateDto dto) {
        Optional<Product> productOptional = repository.findByIdAndDeletedFalse(dto.getId());
        if (productOptional.isEmpty())
            return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                    .status(HttpStatus.NOT_FOUND)
                    .message("Product not found by id : '%s".formatted(dto.getId()))
                    .build()), HttpStatus.OK);

        Product product = mapper.fromUpdateDto(dto, productOptional.get());

        repository.save(product);

        return new ResponseEntity<>(new DataDto<>(true), HttpStatus.OK);
    }


    public ResponseEntity<DataDto<Boolean>> create(ProductCreateDto dto) {
        Product product = mapper.fromCreateDto(dto);
        product.setStatus(new Status("Active", "ACTIVE"));
        repository.save(product);
        return new ResponseEntity<>(new DataDto<>(true), HttpStatus.OK);
    }

    public ResponseEntity<List<ProductDto>> getAllWithFilter(FilterDto filterDto) {
        ProductCriteria criteria = new ProductCriteria(filterDto.getSize(), filterDto.getPage());
        List<ProductDto> list = new ArrayList<>();
        if (filterDto.getSortById() == 0 && filterDto.getPriceId() == 0 && filterDto.getColorId() == 0) {
            return new ResponseEntity<>(Objects.requireNonNull(getAll(criteria).getBody()).getData(), HttpStatus.OK);
        } else {
            List<ProductDto> filterPrice = filterPrice(filterDto, filterSortBy(filterDto, Objects.requireNonNull(getAll(criteria).getBody()).getData(), criteria));
            List<ProductDto> productDtos = filterColor(filterDto, filterPrice);
            list.addAll(productDtos);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    public ResponseEntity<List<ProductDto>> getAllWithSearch(String word) {
        List<Product> productList = repository.findAllByNameContains(word);
        List<ProductDto> productDtos = mapper.toDto(productList);
        for (ProductDto productDto : productDtos) {
            productDto.setImage_path(imageService.getByMain(productDto.getId()).getBody().getImage_path());
        }
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

    public List<ProductDto> filterSortBy(FilterDto filterDto, List<ProductDto> list, ProductCriteria criteria) {
        if (filterDto.getSortById() == 0L) return list;
        List<ProductDto> products = new ArrayList<>();
        if (filterDto.getSortById() == 4L) {
            return getAllDtoWithOrderAsc(criteria);
        } else if (filterDto.getSortById() == 5L) {
            return getAllDtoWithOrderDesc(criteria);
        } else {
            for (ProductDto productDto : list) {
                if (checkProductByFilter(filterDto, productDto.getId())) {
                    products.add(productDto);
                }
            }
        }
        return products;
    }

    public List<ProductDto> filterPrice(FilterDto filterDto, List<ProductDto> list) {
        if (filterDto.getPriceId() == 0L) return list;
        if (filterDto.getPriceId() == 1L) {
            return filterPriceOne(list);
        } else if (filterDto.getPriceId() == 2L) {
            return filterPriceTwo(list);
        } else if (filterDto.getPriceId() == 3L) {
            return filterPriceThree(list);
        } else if (filterDto.getPriceId() == 4L) {
            return filterPriceFour(list);
        } else {
            return filterPriceFive(list);
        }
    }

    public List<ProductDto> filterColor(FilterDto filterDto, List<ProductDto> list) {
        if (filterDto.getColorId() == 0L) return list;
        List<ProductDto> dtos = new ArrayList<>();
        for (ProductDto productDto : list) {
            if (productColorService.checkHaveColor(productDto.getId(), filterDto.getColorId())) {
                dtos.add(productDto);
            }
        }
        return dtos;
    }

    public List<ProductDto> filterPriceOne(List<ProductDto> list) {
        List<ProductDto> productDtos = new ArrayList<>();
        for (ProductDto productDto : list) {
            if (productDto.getPrice() < 50L) {
                productDtos.add(productDto);
            }
        }
        return productDtos;
    }

    public List<ProductDto> filterPriceTwo(List<ProductDto> list) {
        List<ProductDto> productDtos = new ArrayList<>();
        for (ProductDto productDto : list) {
            if (productDto.getPrice() > 50L && productDto.getPrice() < 100L) {
                productDtos.add(productDto);
            }
        }
        return productDtos;
    }

    public List<ProductDto> filterPriceThree(List<ProductDto> list) {
        List<ProductDto> productDtos = new ArrayList<>();
        for (ProductDto productDto : list) {
            if (productDto.getPrice() > 100L && productDto.getPrice() < 150L) {
                productDtos.add(productDto);
            }
        }
        return productDtos;
    }

    public List<ProductDto> filterPriceFour(List<ProductDto> list) {
        List<ProductDto> productDtos = new ArrayList<>();
        for (ProductDto productDto : list) {
            if (productDto.getPrice() > 150L && productDto.getPrice() < 200L) {
                productDtos.add(productDto);
            }
        }
        return productDtos;
    }

    public List<ProductDto> filterPriceFive(List<ProductDto> list) {
        List<ProductDto> productDtos = new ArrayList<>();
        for (ProductDto productDto : list) {
            if (productDto.getPrice() > 200L) {
                productDtos.add(productDto);
            }
        }
        return productDtos;
    }

    public List<ProductDto> getAllDtoWithOrderDesc(ProductCriteria criteria) {
        Pageable request = PageRequest.of(criteria.getPage(), criteria.getSize(), Sort.by("price").descending());
        List<Product> products = repository.findAllByDeletedFalse(request);
        List<ProductDto> productDtos = mapper.toDto(products);
        for (ProductDto productDto : productDtos) {
            productDto.setImage_path(imageService.getByMain(productDto.getId()).getBody().getImage_path());
        }
        return productDtos;
    }

    public List<ProductDto> getAllDtoWithOrderAsc(ProductCriteria criteria) {
        Pageable request = PageRequest.of(criteria.getPage(), criteria.getSize(), Sort.by("price").ascending());
        List<Product> products = repository.findAllByDeletedFalse(request);
        List<ProductDto> productDtos = mapper.toDto(products);
        for (ProductDto productDto : productDtos) {
            productDto.setImage_path(imageService.getByMain(productDto.getId()).getBody().getImage_path());
        }
        return productDtos;
    }

    public Boolean checkProductByFilter(FilterDto filterDto, Long id) {
        return checkBySortByFilter(filterDto.getSortById(), id);
    }

    public Boolean checkBySortByFilter(Long sortedById, Long id) {
        if (sortedById != 0L) {
            if (sortedById == 1L) {
                return checkBySortByPopularity(id);
            } else if (sortedById == 2L) {
                return checkBySortByAvg(id);
            } else if (sortedById == 3L) {
                return checkBySortByNewness(id);
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    private Boolean checkBySortByNewness(Long id) {
        return repository.getById(id).getIs_new();
    }

    private Boolean checkBySortByAvg(Long id) {
        return productRatingService.checkWithAvg(id);
    }

    private Boolean checkBySortByPopularity(Long id) {
        return productRatingService.checkWithPopularity(id);
    }

}
