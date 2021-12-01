package com.musalasoft.drone.Drone.service;

import com.musalasoft.drone.Drone.exceptions.DroneNotEnoughSpaceException;
import com.musalasoft.drone.Drone.exceptions.DroneNotFoundException;
import com.musalasoft.drone.Drone.exceptions.DroneNotReadyException;
import com.musalasoft.drone.Drone.model.Drone;
import com.musalasoft.drone.Drone.model.Medication;
import com.musalasoft.drone.Drone.model.Model;
import com.musalasoft.drone.Drone.model.dto.DroneDTO;
import com.musalasoft.drone.Drone.model.State;
import com.musalasoft.drone.Drone.model.dto.MedicationDTO;
import com.musalasoft.drone.Drone.repository.DroneRepository;
import com.musalasoft.drone.Drone.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DroneService implements IDroneService{

    @Autowired
    DroneRepository droneRepository;

    @Autowired
    MedicationRepository medicationRepository;

    @Override
    public Drone registerDrone(DroneDTO droneDTO) {
        Drone drone = new Drone();
        drone.setCreatedDate(OffsetDateTime.now());
        drone.setUpdatedDate(OffsetDateTime.now());
        drone.setSerialNumber(droneDTO.getSerialNumber());
        drone.setBatteryCapacity(droneDTO.getBatteryCapacity());
        drone.setWeightLimit(droneDTO.getWeightLimit());

        Model model = Model.valueOf(droneDTO.getModel());
        drone.setModel(model);

        State state = State.valueOf(droneDTO.getState());
        drone.setState(state);

        try {
            droneRepository.save(drone);
        }catch (Exception ex){
            return null;
        }

        return drone;
    }

    @Override
    public List<Drone> availableDrones(){
        return droneRepository.findAll();
    }

    @Override
    public List<Medication> checkDroneMedications(Long droneId) {
        Drone drone = droneRepository.findById(droneId).orElseThrow(DroneNotFoundException::new);
        return new ArrayList<>(drone.getMedications());
    }

    @Override
    public Drone loadDroneWithMedications(Long droneId, List<MedicationDTO> medicationDTOList) {
        Drone drone = droneRepository.findById(droneId).orElseThrow(DroneNotFoundException::new);

        Integer availableWeight = drone.getWeightLimit();
        Integer requiredWeight = 0;
        for (MedicationDTO medication: medicationDTOList) {
            requiredWeight+=medication.getWeight();
        }

        if(requiredWeight>availableWeight) throw new DroneNotEnoughSpaceException();

        synchronized(this){
            if(drone.getState() != State.IDLE) throw new DroneNotReadyException();

            for (MedicationDTO medicationDTO: medicationDTOList) {
                Medication medication = new Medication();
                medication.setDrone(drone);
                medication.setCreatedDate(OffsetDateTime.now());
                medication.setUpdatedDate(OffsetDateTime.now());
                medication.setCode(medicationDTO.getCode());
                medication.setImage(medicationDTO.getImage());
                medication.setName(medicationDTO.getName());
                medication.setWeight(medicationDTO.getWeight());

                medicationRepository.insert(drone, medication.getName(), medication.getWeight(), medication.getCode(), medication.getImage());
            }
//            drone.setState(State.LOADED);
//            droneRepository.save(drone);
//            .update(drone.getId(), State.LOADED, drone.getSerialNumber(), drone.getWeightLimit(), drone.getBatteryCapacity(), drone.getModel());
        }

        return drone;
    }
}