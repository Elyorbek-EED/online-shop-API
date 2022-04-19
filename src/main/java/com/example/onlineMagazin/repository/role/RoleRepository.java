package com.example.onlineMagazin.repository.role;

import com.example.onlineMagazin.entity.role.Role;
import com.example.onlineMagazin.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>, AbstractRepository {
}
