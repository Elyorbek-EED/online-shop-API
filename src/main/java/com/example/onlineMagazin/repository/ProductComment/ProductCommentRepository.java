package com.example.onlineMagazin.repository.ProductComment;

import com.example.onlineMagazin.entity.product.ProductComment;
import com.example.onlineMagazin.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCommentRepository extends JpaRepository<ProductComment, Long>, AbstractRepository {
}
