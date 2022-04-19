package com.example.onlineMagazin.service.role;

import com.example.onlineMagazin.dto.language.LanguageCreateDto;
import com.example.onlineMagazin.dto.role.RoleCreateDto;
import com.example.onlineMagazin.entity.language.Language;
import com.example.onlineMagazin.entity.role.Role;
import com.example.onlineMagazin.mappers.role.RoleMapper;
import com.example.onlineMagazin.repository.role.RoleRepository;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.AbstractService;
import com.example.onlineMagazin.validator.role.RoleValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService extends AbstractService<RoleRepository, RoleMapper, RoleValidator> {

    protected RoleService(RoleRepository repository, RoleMapper mapper, RoleValidator validator) {
        super(repository, mapper, validator);
    }

    public ResponseEntity<List<Role>> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Role> getById(Long id) {
        return new ResponseEntity<>(repository.getById(id), HttpStatus.OK);
    }

    public ResponseEntity<Response> delete(Long id) {
        repository.delete(repository.getById(id));
        return new ResponseEntity<>(new Response("Successfully deleted role", HttpStatus.OK.value()), HttpStatus.OK);
    }

    public ResponseEntity<Response> create(RoleCreateDto roleCreateDto) {
        Role role = mapper.fromCreateDto(roleCreateDto);
        repository.save(role);
        return new ResponseEntity<>(new Response("Successfully created role", HttpStatus.OK.value()), HttpStatus.OK);
    }
}
