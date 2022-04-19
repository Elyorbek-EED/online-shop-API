package com.example.onlineMagazin.entity.order;

import com.example.onlineMagazin.entity.base.Auditable;
import com.example.onlineMagazin.entity.userCart.AuthUserCart;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order extends Auditable {
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private AuthUserCart authUserCart;
    private Boolean is_success;
}
