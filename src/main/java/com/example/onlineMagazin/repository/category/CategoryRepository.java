package com.example.onlineMagazin.repository.category;

import com.example.onlineMagazin.entity.category.Category;
import com.example.onlineMagazin.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>, AbstractRepository {
}
