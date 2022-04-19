package com.example.onlineMagazin.repository.productRating;

import com.example.onlineMagazin.entity.productRating.ProductRating;
import com.example.onlineMagazin.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRatingRepository extends JpaRepository<ProductRating, Long>, AbstractRepository {
}
