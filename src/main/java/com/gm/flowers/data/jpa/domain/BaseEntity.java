package com.gm.flowers.data.jpa.domain;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Setter(AccessLevel.PROTECTED)
    private LocalDateTime lastUpdated;

    @PreUpdate
    @PrePersist
    public void updateTimestamps(){
        setLastUpdated(LocalDateTime.now());
    }
}
