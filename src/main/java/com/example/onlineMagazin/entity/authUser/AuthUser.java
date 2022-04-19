package com.example.onlineMagazin.entity.authUser;

import com.example.onlineMagazin.entity.base.Auditable;
import com.example.onlineMagazin.entity.language.Language;
import com.example.onlineMagazin.entity.role.Role;
import com.example.onlineMagazin.entity.status.Status;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "auth_user", indexes = {
        @Index(name = "auth_user_username_key",
                columnList = "username", unique = true
        )
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthUser extends Auditable implements GrantedAuthority{
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone")
    private String phone;

    private String price_type;

    private String image_path;

    @OneToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @Override
    public String getAuthority() {
        return role.getName();
    }

    @Builder(builderMethodName = "childBuilder")
    public AuthUser(Long id, Long createdBy, Long updatedBy, LocalDateTime createdAt, LocalDateTime updatedAt, boolean deleted, String username, String password, String firstName, String lastName, String phone, String email, Language language, Role role, Status status) {
        super(id, createdBy, updatedBy, createdAt, updatedAt, deleted);
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.language = language;
        this.role = role;
        this.status = status;
    }
}

