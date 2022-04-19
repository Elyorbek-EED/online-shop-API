package com.example.onlineMagazin.configs.security;

import com.example.onlineMagazin.configs.security.filters.CustomAuthenticationFilter;
import com.example.onlineMagazin.configs.security.filters.CustomAuthorizationFilter;
import com.example.onlineMagazin.repository.authUser.AuthUserRepository;
import com.example.onlineMagazin.service.auth.AuthUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
    public final static String[] WHITE_LIST = {
            "/api/login",
            "/api/v1/auth/register",
            "/api/v1/refresh-token",
            "/api/v1/auth/token",
            "/swagger-ui/**",
            "/api-docs/**",
            "/api/v1/product/**",
            "/api/v1/category/**",
            "/api/v1/feedback/**",
            "/api/v1/auth/**",
            "/api/v1/color/**",
            "/api/v1/size/**",
            "/api/v1/file/**",
    };
    private final AuthUserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthUserRepository authUserRepository;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests()
                .antMatchers(WHITE_LIST)
                .permitAll()
                .anyRequest().authenticated();
        http.addFilter(new CustomAuthenticationFilter(authenticationManagerBean(), authUserRepository));
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}

