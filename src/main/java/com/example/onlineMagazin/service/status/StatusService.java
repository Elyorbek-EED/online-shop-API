package com.example.onlineMagazin.service.status;

import com.example.onlineMagazin.dto.status.StatusCreateDto;
import com.example.onlineMagazin.entity.status.Status;
import com.example.onlineMagazin.mappers.status.StatusMapper;
import com.example.onlineMagazin.repository.status.StatusRepository;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.AbstractService;
import com.example.onlineMagazin.validator.status.StatusValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService extends AbstractService<StatusRepository, StatusMapper, StatusValidator> {

    protected StatusService(StatusRepository repository, StatusMapper mapper, StatusValidator validator) {
        super(repository, mapper, validator);
    }

    public ResponseEntity<List<Status>> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Status> getById(Long id) {
        return new ResponseEntity<>(repository.getById(id), HttpStatus.OK);
    }

    public ResponseEntity<Response> delete(Long id) {
        repository.delete(repository.getById(id));
        return new ResponseEntity<>(new Response("Successfully deleted status", HttpStatus.OK.value()), HttpStatus.OK);
    }

    public ResponseEntity<Response> create(StatusCreateDto statusCreateDto) {
        Status status = mapper.fromCreateDto(statusCreateDto);
        repository.save(status);
        return new ResponseEntity<>(new Response("Successfully created status", HttpStatus.OK.value()), HttpStatus.OK);
    }
}
