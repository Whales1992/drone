package com.musalasoft.drone.Drone.repository;

import com.musalasoft.drone.Drone.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;

@Resource
public interface DroneRepository extends JpaRepository<Drone, Long>, DroneRepositoryImp {
}