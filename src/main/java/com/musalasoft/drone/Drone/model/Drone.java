package com.musalasoft.drone.Drone.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
public class Drone extends BaseEntity{

    private String serialNumber;

    @Column(name = "weightLimit", length=3)
    private Integer weightLimit;

    private Integer batteryCapacity;

    @OneToMany(mappedBy="drone")
    private Set<Medication> medications;

    @Enumerated(EnumType.STRING)
    @Column(name="state")
    private State state;

    @Enumerated(EnumType.STRING)
    @Column(name="model")
    private Model model;;

}