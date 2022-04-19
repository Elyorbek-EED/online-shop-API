package com.example.onlineMagazin.mappers.size;

import com.example.onlineMagazin.dto.size.SizeCreateDto;
import com.example.onlineMagazin.dto.size.SizeDto;
import com.example.onlineMagazin.dto.size.SizeUpdateDto;
import com.example.onlineMagazin.entity.size.Size;
import com.example.onlineMagazin.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface SizeMapper extends BaseMapper<Size, SizeDto, SizeCreateDto, SizeUpdateDto> {
    @Override
    SizeDto toDto(Size size);

    @Override
    List<SizeDto> toDto(List<Size> e);

    @Override
    Size fromCreateDto(SizeCreateDto sizeCreateDto);

    @Override
    Size fromUpdateDto(SizeUpdateDto d);
}
