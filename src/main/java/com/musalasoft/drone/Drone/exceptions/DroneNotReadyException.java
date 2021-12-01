package com.musalasoft.drone.Drone.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE, reason = "Drone Not Ready..")  // 404
    public class DroneNotReadyException extends RuntimeException{
}
