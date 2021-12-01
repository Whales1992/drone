package com.musalasoft.drone.Drone.repository;

import com.musalasoft.drone.Drone.model.Drone;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface MedicationRepositoryImp {

    @Transactional
    @Query(value = "INSERT INTO medication (drone_id, name, weight, code, image) \n" +
            "VALUES (:drone_id, :name, :weight, :code, :image)", nativeQuery = true)
    void insert(Drone drone_id, String name, Integer weight, String code, String image);
}