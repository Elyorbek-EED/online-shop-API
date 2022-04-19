package com.example.onlineMagazin.repository.productPrice;

import com.example.onlineMagazin.entity.productPrice.ProductPrice;
import com.example.onlineMagazin.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long>, AbstractRepository {
}
