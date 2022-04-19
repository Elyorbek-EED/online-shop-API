package com.example.onlineMagazin.controller.status;

import com.example.onlineMagazin.controller.AbstractController;
import com.example.onlineMagazin.dto.language.LanguageCreateDto;
import com.example.onlineMagazin.dto.status.StatusCreateDto;
import com.example.onlineMagazin.entity.language.Language;
import com.example.onlineMagazin.entity.status.Status;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.status.StatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StatusController extends AbstractController<StatusService> {

    public StatusController(StatusService service) {
        super(service);
    }

    @RequestMapping(value = PATH + "/status/list", method = RequestMethod.GET)
    public ResponseEntity<List<Status>> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = PATH + "/status/{id}", method = RequestMethod.GET)
    public ResponseEntity<Status> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = PATH + "/status/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = PATH + "/status/create", method = RequestMethod.POST)
    public ResponseEntity<Response> create(@RequestBody StatusCreateDto statusCreateDto) {
        return service.create(statusCreateDto);
    }
}
