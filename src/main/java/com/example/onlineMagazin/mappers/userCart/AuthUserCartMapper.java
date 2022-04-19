package com.example.onlineMagazin.mappers.userCart;

import com.example.onlineMagazin.dto.userCart.AuthUserCartCreateDto;
import com.example.onlineMagazin.dto.userCart.AuthUserCartDto;
import com.example.onlineMagazin.dto.userCart.AuthUserCartUpdateDto;
import com.example.onlineMagazin.entity.userCart.AuthUserCart;
import com.example.onlineMagazin.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface AuthUserCartMapper extends BaseMapper<AuthUserCart, AuthUserCartDto, AuthUserCartCreateDto, AuthUserCartUpdateDto> {

    @Override
    AuthUserCartDto toDto(AuthUserCart authUserCart);

    @Override
    List<AuthUserCartDto> toDto(List<AuthUserCart> e);

    @Override
    AuthUserCart fromCreateDto(AuthUserCartCreateDto authUserCartCreateDto);

    @Override
    AuthUserCart fromUpdateDto(AuthUserCartUpdateDto d);
}
