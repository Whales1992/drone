package com.musalasoft.drone.Drone.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MedicationDTO {
    private String name;
    private Integer weight;
    private String code;
    private String image;
}