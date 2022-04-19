package com.example.onlineMagazin.repository.product;

import com.example.onlineMagazin.entity.product.Product;
import com.example.onlineMagazin.repository.AbstractRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;
import java.util.Optional;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 15.03.2022 19:57
 * Project : onlineMagazin
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Long>, AbstractRepository, JpaSpecificationExecutor<Product> {
    List<Product> findAllByDeletedFalse(Pageable request);

    Optional<Product> findByIdAndDeletedFalse(Long id);

    List<Product> findAllByNameContains(String word);
}
