package com.example.onlineMagazin.service.language;

import com.example.onlineMagazin.dto.language.LanguageCreateDto;
import com.example.onlineMagazin.dto.language.LanguageUpdateDto;
import com.example.onlineMagazin.entity.authUser.AuthUser;
import com.example.onlineMagazin.entity.language.Language;
import com.example.onlineMagazin.mappers.language.LanguageMapper;
import com.example.onlineMagazin.repository.language.LanguageRepository;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.AbstractService;
import com.example.onlineMagazin.validator.language.LanguageValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LanguageService extends AbstractService<LanguageRepository, LanguageMapper, LanguageValidator> {

    protected LanguageService(LanguageRepository repository, LanguageMapper mapper, LanguageValidator validator) {
        super(repository, mapper, validator);
    }

    public ResponseEntity<List<Language>> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Language> getById(Long id) {
        return new ResponseEntity<>(repository.getById(id), HttpStatus.OK);
    }

    public ResponseEntity<Response> delete(Long id) {
        repository.delete(repository.getById(id));
        return new ResponseEntity<>(new Response("Successfully deleted language", HttpStatus.OK.value()), HttpStatus.OK);
    }

    public ResponseEntity<Response> create(LanguageCreateDto languageCreateDto) {
        Language language = mapper.fromCreateDto(languageCreateDto);
        repository.save(language);
        return new ResponseEntity<>(new Response("Successfully created language", HttpStatus.OK.value()), HttpStatus.OK);
    }

    public ResponseEntity<Response> update(LanguageUpdateDto languageUpdateDto) {
        Optional<Language> byId = repository.findById(languageUpdateDto.getId());
        Language language = byId.get();
        language.setCode(language.getCode());
        language.setName(language.getName());
        language.setUpdatedAt(LocalDateTime.now());
        repository.save(language);
        return new ResponseEntity<>(new Response("Successfully updated Language", HttpStatus.OK.value()), HttpStatus.OK);
    }
}
