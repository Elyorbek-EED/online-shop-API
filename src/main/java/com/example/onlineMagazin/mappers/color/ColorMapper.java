package com.example.onlineMagazin.mappers.color;

import com.example.onlineMagazin.dto.color.ColorCreateDto;
import com.example.onlineMagazin.dto.color.ColorDto;
import com.example.onlineMagazin.dto.color.ColorUpdateDto;
import com.example.onlineMagazin.entity.color.Color;
import com.example.onlineMagazin.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ColorMapper extends BaseMapper<Color, ColorDto, ColorCreateDto, ColorUpdateDto> {

    @Override
    ColorDto toDto(Color color);

    @Override
    List<ColorDto> toDto(List<Color> e);

    @Override
    Color fromCreateDto(ColorCreateDto colorCreateDto);

    @Override
    Color fromUpdateDto(ColorUpdateDto d);
}
