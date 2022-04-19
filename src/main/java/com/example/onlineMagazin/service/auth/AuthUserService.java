package com.example.onlineMagazin.service.auth;

import com.example.onlineMagazin.configs.encryptions.PasswordEncoderConfigurer;
import com.example.onlineMagazin.dto.auth.*;
import com.example.onlineMagazin.dto.response.AppErrorDto;
import com.example.onlineMagazin.dto.response.DataDto;
import com.example.onlineMagazin.entity.authUser.AuthUser;
import com.example.onlineMagazin.properties.ServerProperties;
import com.example.onlineMagazin.repository.authUser.AuthUserRepository;
import com.example.onlineMagazin.repository.language.LanguageRepository;
import com.example.onlineMagazin.repository.role.RoleRepository;
import com.example.onlineMagazin.repository.status.StatusRepository;
import com.example.onlineMagazin.service.BaseService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthUserService implements BaseService, UserDetailsService {

    private final AuthUserRepository authUserRepository;
    private final ServerProperties serverProperties;
    private final ObjectMapper objectMapper;
    private final RoleRepository roleRepository;
    private final LanguageRepository languageRepository;
    private final StatusRepository statusRepository;


    public AuthUser getById(Long id) {
        return authUserRepository.findById(id).get();
    }


    public ResponseEntity<SessionDto> getToken(AuthUserDto dto) {

        try {
            HttpClient httpclient = HttpClientBuilder.create().build();
            HttpPost httppost = new HttpPost(serverProperties.getServerUrl() + "/api/login");
            byte[] bytes = objectMapper.writeValueAsBytes(dto);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            httppost.addHeader("Content-Type", "application/x-www-form-urlencoded");
            httppost.setEntity(new InputStreamEntity(byteArrayInputStream));

            HttpResponse response = httpclient.execute(httppost);

            JsonNode json_auth = objectMapper.readTree(EntityUtils.toString(response.getEntity()));

            if (json_auth.has("success") && json_auth.get("success").asBoolean()) {
                JsonNode node = json_auth.get("data");
                SessionDto sessionDto = objectMapper.readValue(node.toString(), SessionDto.class);
                return new ResponseEntity<>(sessionDto, HttpStatus.OK);
            }
//            return new ResponseEntity<>(objectMapper.readValue(json_auth.get("error").toString(),
//                    AppErrorDto.class), HttpStatus.OK);
        } catch (IOException e) {
//            return new ResponseEntity<>(AppErrorDto.builder()
//                    .message(e.getLocalizedMessage())
//                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .build(), HttpStatus.OK);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return null;
    }

    public Boolean register(RegisterDto registerDto) {
        AuthUser authUser = AuthUser.childBuilder()
                .username(registerDto.getUsername())
                .firstName(registerDto.getFirstName())
                .lastName(registerDto.getLastName())
                .password(new PasswordEncoderConfigurer().passwordEncoder().encode(registerDto.getPassword()))
                .email(registerDto.getEmail())
                .role(roleRepository.getById(2L))
                .language(languageRepository.getById(1L))
                .status(statusRepository.getById(2L))
                .build();
        authUserRepository.save(authUser);
        return true;
    }

    public ResponseEntity<DataDto<SessionDto>> refreshToken(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    public ResponseEntity<UserDto> getUser(Long id) {
        Optional<AuthUser> authUser = authUserRepository.findById(id);
        UserDto dto = new UserDto();
        dto.setUsername(authUser.get().getUsername());
        dto.setEmail(authUser.get().getEmail());
        dto.setFirstName(authUser.get().getFirstName());
        dto.setLastName(authUser.get().getLastName());
        dto.setPhone(authUser.get().getPhone());
        dto.setLanguage_code(authUser.get().getLanguage().getCode());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser user = authUserRepository.findByUsernameAndDeletedFalse(username).orElseThrow(() -> {
            throw new UsernameNotFoundException("User not found");
        });
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getAuthority())
                .accountLocked(false)
                .accountExpired(false)
                .disabled(false)
                .credentialsExpired(false)
                .build();
    }

    public void delete(Long id) {
        Optional<AuthUser> byId = authUserRepository.findById(id);
        authUserRepository.delete(byId.get());
    }

    public void update(AuthUserUpdateDto authUserUpdateDto) {
        Optional<AuthUser> byId = authUserRepository.findById(authUserUpdateDto.getId());
        AuthUser authUser = byId.get();
        authUser.setUsername(authUserUpdateDto.getUsername());
        authUser.setLastName(authUserUpdateDto.getLastName());
        authUser.setEmail(authUserUpdateDto.getEmail());
        authUser.setFirstName(authUserUpdateDto.getFirstName());
        authUser.setPhone(authUserUpdateDto.getPhone());
        authUser.setLanguage(languageRepository.getById(authUserUpdateDto.getLanguage_id()));
        authUserRepository.save(authUser);
    }

    public Long getIdByUsername(String username) {
        return authUserRepository.findByUsernameAndDeletedFalse(username).get().getId();
    }
}