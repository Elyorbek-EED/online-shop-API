package com.example.onlineMagazin.service.category;

import com.example.onlineMagazin.dto.category.CategoryCreateDto;
import com.example.onlineMagazin.dto.category.CategoryUpdateDto;
import com.example.onlineMagazin.entity.category.Category;
import com.example.onlineMagazin.mappers.category.CategoryMapper;
import com.example.onlineMagazin.repository.category.CategoryRepository;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.AbstractService;
import com.example.onlineMagazin.validator.category.CategoryValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryService extends AbstractService<CategoryRepository, CategoryMapper, CategoryValidator> {

    protected CategoryService(CategoryRepository repository, CategoryMapper mapper, CategoryValidator validator) {
        super(repository, mapper, validator);
    }

    public ResponseEntity<List<Category>> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Category> getById(Long id) {
        return new ResponseEntity<>(repository.findById(id).get(), HttpStatus.OK);
    }

    public ResponseEntity<Response> delete(Long id) {
        repository.delete(repository.getById(id));
        return new ResponseEntity<>(new Response("Successfully deleted Category", HttpStatus.OK.value()), HttpStatus.OK);
    }

    public ResponseEntity<Response> create(CategoryCreateDto categoryCreateDto) {
        Category category = mapper.fromCreateDto(categoryCreateDto);
        repository.save(category);
        return new ResponseEntity<>(new Response("Successfully created Category", HttpStatus.OK.value()), HttpStatus.OK);
    }

    public ResponseEntity<Response> update(CategoryUpdateDto categoryUpdateDto) {
        Category category = repository.getById(categoryUpdateDto.getId());
        category.setName(categoryUpdateDto.getName());
        category.setUpdatedAt(LocalDateTime.now());
        repository.save(category);
        return new ResponseEntity<>(new Response("Successfully updated Category", HttpStatus.OK.value()), HttpStatus.OK);
    }
}
