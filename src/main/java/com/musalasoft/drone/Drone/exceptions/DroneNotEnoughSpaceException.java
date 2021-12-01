package com.musalasoft.drone.Drone.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE, reason = "Drone Can't Take This Load.")  // 404
    public class DroneNotEnoughSpaceException extends RuntimeException{
}
