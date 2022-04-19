package com.example.onlineMagazin.repository.productSize;

import com.example.onlineMagazin.entity.product.ProductSize;
import com.example.onlineMagazin.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSizeRepository extends JpaRepository<ProductSize, Long>, AbstractRepository {
}
