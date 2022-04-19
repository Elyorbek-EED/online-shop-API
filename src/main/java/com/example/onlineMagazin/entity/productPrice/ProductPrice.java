package com.example.onlineMagazin.entity.productPrice;

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
@Table(name = "product_price")
public class ProductPrice extends Auditable {
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "USD")
    private Double usd;
    @Column(name = "RUB")
    private Double rub;
    @Column(name = "UZS")
    private Double uzs;
}
