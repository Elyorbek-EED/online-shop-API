package com.example.onlineMagazin.mappers.role;

import com.example.onlineMagazin.dto.role.RoleCreateDto;
import com.example.onlineMagazin.dto.role.RoleDto;
import com.example.onlineMagazin.dto.role.RoleUpdateDto;
import com.example.onlineMagazin.entity.role.Role;
import com.example.onlineMagazin.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface RoleMapper extends BaseMapper<Role, RoleDto, RoleCreateDto, RoleUpdateDto> {

    @Override
    RoleDto toDto(Role role);

    @Override
    List<RoleDto> toDto(List<Role> e);

    @Override
    Role fromCreateDto(RoleCreateDto roleCreateDto);

    @Override
    Role fromUpdateDto(RoleUpdateDto d);
}
