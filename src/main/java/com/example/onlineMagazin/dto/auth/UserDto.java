package com.example.onlineMagazin.dto.auth;

import com.example.onlineMagazin.entity.language.Language;
import com.example.onlineMagazin.entity.role.Role;
import com.example.onlineMagazin.entity.status.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String language_code;
}
