package com.example.onlineMagazin.controller.language;

import com.example.onlineMagazin.controller.AbstractController;
import com.example.onlineMagazin.dto.language.LanguageCreateDto;
import com.example.onlineMagazin.dto.language.LanguageUpdateDto;
import com.example.onlineMagazin.entity.language.Language;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.language.LanguageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LanguageController extends AbstractController<LanguageService> {

    public LanguageController(LanguageService service) {
        super(service);
    }

    @RequestMapping(value = PATH + "/language/update", method = RequestMethod.PUT)
    public ResponseEntity<Response> update(@RequestBody LanguageUpdateDto languageUpdateDto) {
        return service.update(languageUpdateDto);
    }

    @RequestMapping(value = PATH + "/language/list", method = RequestMethod.GET)
    public ResponseEntity<List<Language>> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = PATH + "/language/{id}", method = RequestMethod.GET)
    public ResponseEntity<Language> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = PATH + "/language/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = PATH + "/language/create", method = RequestMethod.POST)
    public ResponseEntity<Response> create(@RequestBody LanguageCreateDto languageCreateDto) {
        return service.create(languageCreateDto);
    }
}
