package com.example.onlineMagazin.controller.role;

import com.example.onlineMagazin.controller.AbstractController;
import com.example.onlineMagazin.dto.language.LanguageCreateDto;
import com.example.onlineMagazin.dto.role.RoleCreateDto;
import com.example.onlineMagazin.entity.language.Language;
import com.example.onlineMagazin.entity.role.Role;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.role.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController extends AbstractController<RoleService> {

    public RoleController(RoleService service) {
        super(service);
    }

    @RequestMapping(value = PATH + "/role/list", method = RequestMethod.GET)
    public ResponseEntity<List<Role>> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = PATH + "/role/{id}", method = RequestMethod.GET)
    public ResponseEntity<Role> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = PATH + "/role/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = PATH + "/role/create", method = RequestMethod.POST)
    public ResponseEntity<Response> create(@RequestBody RoleCreateDto roleCreateDto) {
        return service.create(roleCreateDto);
    }
}
