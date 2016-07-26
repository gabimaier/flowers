package com.gm.flowers.data.jpa.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class User extends BaseEntity {
    private String username;

    @OneToMany(mappedBy = "user")
    private List<Plant> plants;
}
