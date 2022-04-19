package com.example.onlineMagazin.mappers.status;

import com.example.onlineMagazin.dto.status.StatusCreateDto;
import com.example.onlineMagazin.dto.status.StatusDto;
import com.example.onlineMagazin.dto.status.StatusUpdateDto;
import com.example.onlineMagazin.entity.status.Status;
import com.example.onlineMagazin.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface StatusMapper extends BaseMapper<Status, StatusDto, StatusCreateDto, StatusUpdateDto> {
    @Override
    StatusDto toDto(Status status);

    @Override
    List<StatusDto> toDto(List<Status> e);

    @Override
    Status fromCreateDto(StatusCreateDto statusCreateDto);

    @Override
    Status fromUpdateDto(StatusUpdateDto d);
}
