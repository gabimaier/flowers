package com.gm.flowers.data.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
public class User extends BaseEntity {
    private String username;

    @OneToMany(mappedBy = "user")
    private Set<Plant> plants;

    @OneToMany(mappedBy = "user")
    private Set<Photo> photos;

    @OneToMany(mappedBy = "user")
    private Set<Memory> memories;

    @OneToMany(mappedBy = "user")
    private Set<Species> species;
}
