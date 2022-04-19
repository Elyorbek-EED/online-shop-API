package com.example.onlineMagazin.repository.productLike;

import com.example.onlineMagazin.entity.product.ProductLike;
import com.example.onlineMagazin.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@EnableJpaRepositories("com.example.onlineMagazin.repository.productLike")
public interface ProductLikeRepository extends JpaRepository<ProductLike, Long>, AbstractRepository {

    @Modifying
    @Transactional
    @Query(value = "delete from online_store.public.product_like where product_id =:productId and user_id =:userId", nativeQuery = true)
    void deleteWith(@Param("productId") Long productId, @Param("userId") Long userId);
}
