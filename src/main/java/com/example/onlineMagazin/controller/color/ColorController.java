package com.example.onlineMagazin.controller.color;

import com.example.onlineMagazin.controller.AbstractController;
import com.example.onlineMagazin.dto.color.ColorCreateDto;
import com.example.onlineMagazin.dto.color.ColorUpdateDto;
import com.example.onlineMagazin.entity.color.Color;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.color.ColorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ColorController extends AbstractController<ColorService> {

    public ColorController(ColorService service) {
        super(service);
    }

    @RequestMapping(value = PATH + "/color/list", method = RequestMethod.GET)
    public ResponseEntity<List<Color>> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = PATH + "/color/{id}", method = RequestMethod.GET)
    public ResponseEntity<Color> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = PATH + "/color/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = PATH + "/color/create", method = RequestMethod.POST)
    public ResponseEntity<Response> create(@RequestBody ColorCreateDto colorCreateDto) {
        return service.create(colorCreateDto);
    }

    @RequestMapping(value = PATH + "/color/update", method = RequestMethod.PUT)
    public ResponseEntity<Response> update(@RequestBody ColorUpdateDto colorUpdateDto) {
        return service.update(colorUpdateDto);
    }
}
