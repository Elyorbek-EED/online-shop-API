package com.example.onlineMagazin.repository.productColor;

import com.example.onlineMagazin.entity.product.ProductColor;
import com.example.onlineMagazin.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductColorRepository extends JpaRepository<ProductColor, Long>, AbstractRepository {
}
