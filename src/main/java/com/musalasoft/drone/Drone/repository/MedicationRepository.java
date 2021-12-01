package com.musalasoft.drone.Drone.repository;

import com.musalasoft.drone.Drone.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;

@Resource
public interface MedicationRepository extends JpaRepository<Medication, Long>, MedicationRepositoryImp {
}