package com.musalasoft.drone.Drone.controller;

import com.musalasoft.drone.Drone.model.Drone;
import com.musalasoft.drone.Drone.model.Medication;
import com.musalasoft.drone.Drone.model.dto.DroneDTO;
import com.musalasoft.drone.Drone.model.dto.MedicationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IDroneController {
    @GetMapping("/")
    public ResponseEntity<List<Drone>> availableDrones();

    @PostMapping("/")
    public ResponseEntity<Drone> registerDrone(@RequestBody DroneDTO droneDTO);

    @GetMapping("/medications")
    public ResponseEntity<List<Medication>> checkDroneMedications(@RequestParam long id);

    @PutMapping("/")
    public ResponseEntity<Drone> loadDroneWithMedications(@RequestParam long id, @RequestBody List<MedicationDTO> medicationDTOList);
}