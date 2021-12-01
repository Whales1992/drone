package com.musalasoft.drone.Drone.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class DroneDTO {
    private String serialNumber;
    private String model;
    private Integer weightLimit;
    private Integer batteryCapacity;
    private String state;
}