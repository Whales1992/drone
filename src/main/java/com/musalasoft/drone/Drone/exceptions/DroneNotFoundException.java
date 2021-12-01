package com.musalasoft.drone.Drone.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "Drone Not Found.")  // 404
    public class DroneNotFoundException extends RuntimeException{
}
