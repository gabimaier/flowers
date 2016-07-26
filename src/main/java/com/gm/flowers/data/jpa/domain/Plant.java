package com.gm.flowers.data.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Plant extends BaseEntity {
    private Double latitude;
    private Double longitude;

    @Enumerated(EnumType.STRING)
    private PlantCategory category;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private Integer numberOfMistakeReports;
    private Integer numberOfInappropriateReports;
}
