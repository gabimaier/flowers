package com.gm.flowers.data.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Feedback{
    private Integer numberOfVotes;
    private Integer numberOfMistakeReports;
    private Integer numberOfInappropriateReports;
}
