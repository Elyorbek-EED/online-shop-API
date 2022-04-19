package com.example.onlineMagazin.entity.productRating;

import com.example.onlineMagazin.entity.base.Auditable;
import com.example.onlineMagazin.entity.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_rating")
public class ProductRating extends Auditable {
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "count_like")
    private Long countLike;
    @OneToOne
    @JoinColumn(name = "rating_type_id")
    private ProductRatingType productRatingType;
}
