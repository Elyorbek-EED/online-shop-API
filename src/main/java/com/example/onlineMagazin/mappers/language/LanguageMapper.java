package com.example.onlineMagazin.mappers.language;

import com.example.onlineMagazin.dto.language.LanguageCreateDto;
import com.example.onlineMagazin.dto.language.LanguageDto;
import com.example.onlineMagazin.dto.language.LanguageUpdateDto;
import com.example.onlineMagazin.entity.language.Language;
import com.example.onlineMagazin.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface LanguageMapper extends BaseMapper<Language, LanguageDto, LanguageCreateDto, LanguageUpdateDto> {
    @Override
    LanguageDto toDto(Language language);

    @Override
    List<LanguageDto> toDto(List<Language> e);

    @Override
    Language fromCreateDto(LanguageCreateDto languageCreateDto);

    @Override
    Language fromUpdateDto(LanguageUpdateDto d);
}
