package com.example.onlineMagazin.entity.userCart;

import com.example.onlineMagazin.entity.authUser.AuthUser;
import com.example.onlineMagazin.entity.base.Auditable;
import com.example.onlineMagazin.entity.product.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "auth_user_cart")
public class AuthUserCart extends Auditable {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AuthUser authUser;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Integer count;
    private Boolean accept;
}
