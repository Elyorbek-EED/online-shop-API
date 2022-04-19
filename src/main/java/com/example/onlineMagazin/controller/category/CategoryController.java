package com.example.onlineMagazin.controller.category;

import com.example.onlineMagazin.controller.AbstractController;
import com.example.onlineMagazin.dto.category.CategoryCreateDto;
import com.example.onlineMagazin.dto.category.CategoryUpdateDto;
import com.example.onlineMagazin.entity.category.Category;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.category.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController extends AbstractController<CategoryService> {

    public CategoryController(CategoryService service) {
        super(service);
    }

    @RequestMapping(value = PATH + "/category/list", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = PATH + "/category/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = PATH + "/category/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = PATH + "/category/create", method = RequestMethod.POST)
    public ResponseEntity<Response> create(@RequestBody CategoryCreateDto categoryCreateDto) {
        return service.create(categoryCreateDto);
    }

    @RequestMapping(value = PATH + "/category/update", method = RequestMethod.PUT)
    public ResponseEntity<Response> update(@RequestBody CategoryUpdateDto categoryUpdateDto) {
        return service.update(categoryUpdateDto);
    }
}
