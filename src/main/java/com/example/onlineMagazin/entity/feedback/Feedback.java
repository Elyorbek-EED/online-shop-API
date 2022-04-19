package com.example.onlineMagazin.entity.feedback;

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
@Table(name = "feedback")
public class Feedback extends Auditable {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AuthUser authUser;
    private String message;
}
