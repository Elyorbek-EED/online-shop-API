package com.example.onlineMagazin.entity.product;

import com.example.onlineMagazin.entity.authUser.AuthUser;
import com.example.onlineMagazin.entity.base.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_comment")
public class ProductComment extends Auditable {
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private String message;
    private String rating;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AuthUser authUser;
}
