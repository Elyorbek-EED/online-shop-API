package com.example.onlineMagazin.entity.product;

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
@Table(name = "product_image")
public class ProductImage extends Auditable {
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private String image_path;
    private Boolean is_main;
}
