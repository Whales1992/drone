package com.musalasoft.drone.Drone.service;

import com.musalasoft.drone.Drone.model.Drone;
import com.musalasoft.drone.Drone.model.Medication;
import com.musalasoft.drone.Drone.model.dto.DroneDTO;
import com.musalasoft.drone.Drone.model.dto.MedicationDTO;

import javax.transaction.Transactional;
import java.util.List;

public interface IDroneService {
    public Drone registerDrone(DroneDTO droneDTO);

    @Transactional
    public List<Drone> availableDrones();

    public List<Medication> checkDroneMedications(Long droneId);

    public Drone loadDroneWithMedications(Long droneId, List<MedicationDTO> medicationDTOList);
}