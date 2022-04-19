package com.example.onlineMagazin.repository.color;

import com.example.onlineMagazin.entity.color.Color;
import com.example.onlineMagazin.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Long>, AbstractRepository {
}
