package com.example.onlineMagazin.service.color;

import com.example.onlineMagazin.dto.color.ColorCreateDto;
import com.example.onlineMagazin.dto.color.ColorUpdateDto;
import com.example.onlineMagazin.entity.color.Color;
import com.example.onlineMagazin.mappers.color.ColorMapper;
import com.example.onlineMagazin.repository.color.ColorRepository;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.AbstractService;
import com.example.onlineMagazin.validator.color.ColorValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ColorService extends AbstractService<ColorRepository, ColorMapper, ColorValidator> {

    protected ColorService(ColorRepository repository, ColorMapper mapper, ColorValidator validator) {
        super(repository, mapper, validator);
    }

    public ResponseEntity<List<Color>> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Color> getById(Long id) {
        return new ResponseEntity<>(repository.findById(id).get(), HttpStatus.OK);
    }

    public ResponseEntity<Response> delete(Long id) {
        repository.delete(repository.getById(id));
        return new ResponseEntity<>(new Response("Successfully deleted Category", HttpStatus.OK.value()), HttpStatus.OK);
    }

    public ResponseEntity<Response> create(ColorCreateDto colorCreateDto) {
        Color color = mapper.fromCreateDto(colorCreateDto);
        repository.save(color);
        return new ResponseEntity<>(new Response("Successfully created Category", HttpStatus.OK.value()), HttpStatus.OK);
    }

    public ResponseEntity<Response> update(ColorUpdateDto colorUpdateDto) {
        Color color = repository.getById(colorUpdateDto.getId());
        color.setName(colorUpdateDto.getName());
        color.setUpdatedAt(LocalDateTime.now());
        repository.save(color);
        return new ResponseEntity<>(new Response("Successfully updated Category", HttpStatus.OK.value()), HttpStatus.OK);
    }
}
