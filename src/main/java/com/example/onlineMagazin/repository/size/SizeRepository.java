package com.example.onlineMagazin.repository.size;

import com.example.onlineMagazin.entity.size.Size;
import com.example.onlineMagazin.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepository extends JpaRepository<Size, Long>, AbstractRepository {
}
