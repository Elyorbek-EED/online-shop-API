package com.example.onlineMagazin.controller.auth;

import com.example.onlineMagazin.controller.AbstractController;
import com.example.onlineMagazin.dto.auth.*;
import com.example.onlineMagazin.dto.response.DataDto;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.auth.AuthUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthController extends AbstractController<AuthUserService> {

    public AuthController(AuthUserService service) {
        super(service);
    }


    @RequestMapping(value = PATH + "/auth/token", method = RequestMethod.POST)
    public ResponseEntity<SessionDto> getToken(@RequestBody AuthUserDto dto) {
        return service.getToken(dto);
    }

    @RequestMapping(value = PATH + "/auth/refresh-token", method = RequestMethod.GET)
    public ResponseEntity<DataDto<SessionDto>> getToken(HttpServletRequest request, HttpServletResponse response) {
        return service.refreshToken(request, response);
    }

    @RequestMapping(value = PATH + "/auth/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        return service.getUser(id);
    }

    @RequestMapping(value = PATH + "/auth/register", method = RequestMethod.POST)
    public Response register(@RequestBody RegisterDto registerDto) {
        Boolean register = service.register(registerDto);
        Response response = new Response();
        if (register) {
            response.setCode(200);
            response.setMessage("Successfully Register");
        } else {
            response.setCode(403);
            response.setMessage("Failed Register");
        }
        return response;
    }

    @RequestMapping(value = PATH + "/auth/delete/{id}", method = RequestMethod.DELETE)
    public Response delete(@PathVariable Long id) {
        Response response = new Response();
        service.delete(id);
        response.setMessage("Successfully deleted user");
        response.setCode(200);
        return response;
    }

    @RequestMapping(value = PATH + "/auth/update", method = RequestMethod.PUT)
    public Response update(@RequestBody AuthUserUpdateDto authUserUpdateDto) {
        Response response = new Response();
        service.update(authUserUpdateDto);
        response.setMessage("successfully updated user");
        response.setCode(200);
        return response;
    }

}
