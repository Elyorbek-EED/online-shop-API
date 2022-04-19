package com.example.onlineMagazin.service.size;

import com.example.onlineMagazin.dto.size.SizeCreateDto;
import com.example.onlineMagazin.entity.size.Size;
import com.example.onlineMagazin.mappers.size.SizeMapper;
import com.example.onlineMagazin.repository.size.SizeRepository;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.AbstractService;
import com.example.onlineMagazin.validator.size.SizeValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService extends AbstractService<SizeRepository, SizeMapper, SizeValidator> {

    protected SizeService(SizeRepository repository, SizeMapper mapper, SizeValidator validator) {
        super(repository, mapper, validator);
    }

    public ResponseEntity<List<Size>> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Size> getById(Long id) {
        return new ResponseEntity<>(repository.getById(id), HttpStatus.OK);
    }

    public ResponseEntity<Response> delete(Long id) {
        repository.delete(repository.getById(id));
        return new ResponseEntity<>(new Response("Successfully deleted Size", 200), HttpStatus.OK);
    }

    public ResponseEntity<Response> create(SizeCreateDto sizeCreateDto) {
        Size size = mapper.fromCreateDto(sizeCreateDto);
        repository.save(size);
        return new ResponseEntity<>(new Response("Successfully created Size", 200), HttpStatus.OK);
    }
}
