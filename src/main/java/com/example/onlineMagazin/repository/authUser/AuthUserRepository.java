package com.example.onlineMagazin.repository.authUser;

import com.example.onlineMagazin.entity.authUser.AuthUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AuthUserRepository extends CrudRepository<AuthUser, Long> {
    Optional<AuthUser> findByUsernameAndDeletedFalse(String name);
}