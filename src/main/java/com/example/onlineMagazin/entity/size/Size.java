package com.example.onlineMagazin.entity.size;

import com.example.onlineMagazin.entity.base.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "size")
public class Size extends Auditable {
    @Column(unique = true)
    private String code;
    private Integer number;
}
