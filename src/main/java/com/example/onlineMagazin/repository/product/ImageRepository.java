package com.example.onlineMagazin.repository.product;

import com.example.onlineMagazin.entity.product.ProductImage;
import com.example.onlineMagazin.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 17.03.2022 0:18
 * Project : onlineMagazin
 */
@Repository
public interface ImageRepository extends JpaRepository<ProductImage,Long>, AbstractRepository {

    List<ProductImage> findAllByProductId(Long product_id);

    Optional<ProductImage> findByIdAndDeletedFalse(Long id);

}
