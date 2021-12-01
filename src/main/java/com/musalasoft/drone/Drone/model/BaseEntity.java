package com.musalasoft.drone.Drone.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Setter
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements EntityIdentifier, WithDates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "created_date", updatable = false, nullable = true)
    @CreatedDate
    private OffsetDateTime createdDate;

    @Column(name = "updated_date", updatable = true, nullable = true)
    @LastModifiedDate
    private OffsetDateTime updatedDate;
}
