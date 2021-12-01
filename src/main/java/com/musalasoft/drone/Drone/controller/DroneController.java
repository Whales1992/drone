package com.musalasoft.drone.Drone.controller;

import com.musalasoft.drone.Drone.model.Drone;
import com.musalasoft.drone.Drone.model.Medication;
import com.musalasoft.drone.Drone.model.dto.DroneDTO;
import com.musalasoft.drone.Drone.model.dto.MedicationDTO;
import com.musalasoft.drone.Drone.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@Controller
@RequestMapping("/api")
public class DroneController implements IDroneController {

    @Autowired
    private DroneService droneService;

    @Override
    public ResponseEntity<List<Drone>> availableDrones() {
        return new ResponseEntity<>(droneService.availableDrones(), OK);
    }

    @Override
    public ResponseEntity<Drone> registerDrone(DroneDTO droneDTO) {
        Drone registeredDrone = droneService.registerDrone(droneDTO);
        return new ResponseEntity<>(registeredDrone, registeredDrone != null ? OK : BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<Medication>> checkDroneMedications(long id) {
        List<Medication> medicationList = droneService.checkDroneMedications(id);
        return new ResponseEntity<>(medicationList, OK);
    }

    @Override
    public ResponseEntity<Drone> loadDroneWithMedications(long id, List<MedicationDTO> medicationDTOList) {
        Drone loadedDrone = droneService.loadDroneWithMedications(id, medicationDTOList);
        return new ResponseEntity<>(loadedDrone, OK);
    }

}