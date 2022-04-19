package com.example.onlineMagazin;

import com.example.onlineMagazin.properties.OpenApiProperties;
import com.example.onlineMagazin.properties.ServerProperties;
import com.example.onlineMagazin.repository.authUser.AuthUserRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties({
        OpenApiProperties.class,
        ServerProperties.class
})
@OpenAPIDefinition
@RequiredArgsConstructor
public class OnlineMagazin {

    private final AuthUserRepository authUserRepository;
    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(OnlineMagazin.class, args);
    }
}
