package com.example.onlineMagazin.entity.product;

import com.example.onlineMagazin.entity.base.Auditable;
import com.example.onlineMagazin.entity.category.Category;
import com.example.onlineMagazin.entity.status.Status;
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
@Table(name = "product")
public class Product extends Auditable {
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String name;
    private String description;
    private Double price;
    private Boolean is_new;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
}
