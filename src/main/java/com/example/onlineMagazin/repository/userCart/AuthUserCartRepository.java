package com.example.onlineMagazin.repository.userCart;

import com.example.onlineMagazin.entity.userCart.AuthUserCart;
import com.example.onlineMagazin.repository.AbstractRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthUserCartRepository extends JpaRepository<AuthUserCart, Long>, AbstractRepository {

    @Query(value = "select auc from AuthUserCart auc where auc.authUser.id = :user_id ")
    List<AuthUserCart> findAuthUserCartsByAuthUserById(@Param("user_id") Long user_id);

    List<AuthUserCart> findAuthUserCartByDeletedFalse(Pageable pageable);

    List<AuthUserCart> findAuthUserCartByDeletedFalse();
}
