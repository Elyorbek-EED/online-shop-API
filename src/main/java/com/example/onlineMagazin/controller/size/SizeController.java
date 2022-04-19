package com.example.onlineMagazin.controller.size;

import com.example.onlineMagazin.controller.AbstractController;
import com.example.onlineMagazin.dto.size.SizeCreateDto;
import com.example.onlineMagazin.entity.size.Size;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.size.SizeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SizeController extends AbstractController<SizeService> {

    public SizeController(SizeService service) {
        super(service);
    }

    @RequestMapping(value = PATH + "/size/list", method = RequestMethod.GET)
    public ResponseEntity<List<Size>> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = PATH + "/size/{id}", method = RequestMethod.GET)
    public ResponseEntity<Size> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = PATH + "/size/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = PATH + "/size/create", method = RequestMethod.POST)
    public ResponseEntity<Response> create(@RequestBody SizeCreateDto sizeCreateDto) {
        return service.create(sizeCreateDto);
    }
}
