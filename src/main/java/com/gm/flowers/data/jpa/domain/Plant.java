package com.gm.flowers.data.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Plant extends BaseEntity {
    @Embedded
    private Location gps;

    @Enumerated(EnumType.STRING)
    private PlantCategory category;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Embedded
    private Feedback feedback;

    @OneToMany(mappedBy = "plant")
    private Set<Photo> photos;

    @OneToMany(mappedBy = "plant")
    private Set<Memory> memories;

    @OneToMany(mappedBy = "plant")
    private Set<Species> species;
}
