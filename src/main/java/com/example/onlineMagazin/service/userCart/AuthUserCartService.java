package com.example.onlineMagazin.service.userCart;

import com.example.onlineMagazin.criteria.cart.CartCriteria;
import com.example.onlineMagazin.dto.productImage.ImagePathDto;
import com.example.onlineMagazin.dto.response.DataDto;
import com.example.onlineMagazin.dto.userCart.AuthUserCartCreateDto;
import com.example.onlineMagazin.dto.userCart.AuthUserCartUpdateDto;
import com.example.onlineMagazin.dto.userCart.CartFullDto;
import com.example.onlineMagazin.entity.product.Product;
import com.example.onlineMagazin.entity.userCart.AuthUserCart;
import com.example.onlineMagazin.mappers.userCart.AuthUserCartMapper;
import com.example.onlineMagazin.repository.authUser.AuthUserRepository;
import com.example.onlineMagazin.repository.product.ProductRepository;
import com.example.onlineMagazin.repository.userCart.AuthUserCartRepository;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.AbstractService;
import com.example.onlineMagazin.service.product.ImageService;
import com.example.onlineMagazin.validator.userCart.AuthUserCartValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AuthUserCartService extends AbstractService<AuthUserCartRepository, AuthUserCartMapper, AuthUserCartValidator> {

    private final ProductRepository productRepository;
    private final AuthUserRepository authUserRepository;
    private final ImageService imageService;

    @Autowired
    protected AuthUserCartService(AuthUserCartRepository repository, AuthUserCartMapper mapper, AuthUserCartValidator validator, ProductRepository productRepository, AuthUserRepository authUserRepository, ImageService imageService) {
        super(repository, mapper, validator);
        this.productRepository = productRepository;
        this.authUserRepository = authUserRepository;
        this.imageService = imageService;
    }

    public ResponseEntity<List<CartFullDto>> getAll(Long id) {
        List<AuthUserCart> carts = repository.findAuthUserCartsByAuthUserById(id);
        List<CartFullDto> fullCarts = new ArrayList<>();
        for (AuthUserCart cart : carts) {
            if (Objects.nonNull(cart)) {
                fullCarts.add(toFullCartDto(cart));
            }
        }
        return new ResponseEntity<>(fullCarts, HttpStatus.OK);
    }

    private CartFullDto toFullCartDto(AuthUserCart cart) {
        CartFullDto cartFullDto = new CartFullDto();
        cartFullDto.setId(cart.getId());
        cartFullDto.setUserId(cart.getAuthUser().getId());
        cartFullDto.setProductName(cart.getProduct().getName());
        cartFullDto.setProductId(cart.getProduct().getId());
        cartFullDto.setPrice(cart.getProduct().getPrice());
        cartFullDto.setImage_path(getMainImage(cart.getProduct()).getImage_path());
        cartFullDto.setCount(cart.getCount());
        return cartFullDto;
    }

    private ImagePathDto getMainImage(Product product) {
        return new ImagePathDto(Objects.requireNonNull(imageService.getByMain(product.getId()).getBody()).getImage_path());
    }

    public ResponseEntity<AuthUserCart> getById(Long id) {
        return new ResponseEntity<>(repository.getById(id), HttpStatus.OK);
    }

    public ResponseEntity<Response> delete(Long id) {
        repository.delete(repository.getById(id));
        return new ResponseEntity<>(new Response("Successfully deleted Auth User Cart", HttpStatus.OK.value())  , HttpStatus.OK);
    }

    public ResponseEntity<Response> create(AuthUserCartCreateDto authUserCartCreateDto) {
        AuthUserCart authUserCart = mapper.fromCreateDto(authUserCartCreateDto);
        authUserCart.setAuthUser(authUserRepository.findById(authUserCartCreateDto.getUserId()).get());
        authUserCart.setProduct(productRepository.getById(authUserCartCreateDto.getProductId()));
        repository.save(authUserCart);
        return new ResponseEntity<>(new Response("Successfully created Auth User Cart", HttpStatus.OK.value()), HttpStatus.OK);
    }


    public ResponseEntity<Response> update(AuthUserCartUpdateDto authUserCartUpdateDto) {
        Optional<AuthUserCart> byId = repository.findById(authUserCartUpdateDto.getId());
        AuthUserCart authUserCart = byId.get();
        authUserCart.setCount(authUserCartUpdateDto.getCount());
        authUserCart.setUpdatedAt(LocalDateTime.now());
        repository.save(authUserCart);
        return new ResponseEntity<>(new Response("Successfully updated Auth User Cart", HttpStatus.OK.value()), HttpStatus.OK);
    }

    public ResponseEntity<DataDto<List<CartFullDto>>> getCarts(CartCriteria criteria) {
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<AuthUserCart> carts = repository.findAuthUserCartByDeletedFalse(pageable);
        List<CartFullDto> cartFullDtos = new ArrayList<>();

        for (AuthUserCart cart : carts) {
            cartFullDtos.add(toFullCartDto(cart));
        }
        return new ResponseEntity<>(new DataDto<>(cartFullDtos, (long) cartFullDtos.size()), HttpStatus.OK);
    }

    public ResponseEntity<Integer> sumCartPrice(Long userId) {
        List<AuthUserCart> carts = repository.findAuthUserCartsByAuthUserById(userId);
        return new ResponseEntity<>(carts.stream().mapToInt(cart -> (int) (cart.getCount() * cart.getProduct().getPrice())).sum(), HttpStatus.OK);
    }

    public ResponseEntity<Integer> sumCartPrices() {
        List<AuthUserCart> carts = repository.findAuthUserCartByDeletedFalse();
        return new ResponseEntity<>(carts.stream().mapToInt(cart -> (int) (cart.getCount() * cart.getProduct().getPrice())).sum(), HttpStatus.OK);
    }
}

