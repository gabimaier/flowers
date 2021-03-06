package com.gm.flowers.data.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Photo extends BaseEntity {
    private String url;
    private String title;

    @Embedded
    private Feedback feedback;

    @ManyToOne
    @JoinColumn(name = "plantId")
    private Plant plant;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;
}
