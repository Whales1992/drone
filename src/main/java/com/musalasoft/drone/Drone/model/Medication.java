package com.musalasoft.drone.Drone.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Setter
@Getter
@Entity
public class Medication extends BaseEntity{
    @ManyToOne
    @JoinColumn(name="drone_id", nullable=false)
    private Drone drone;

    private String name;
    private Integer weight;
    private String code;
    private String image;
}
