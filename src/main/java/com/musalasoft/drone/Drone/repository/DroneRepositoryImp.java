package com.musalasoft.drone.Drone.repository;

import com.musalasoft.drone.Drone.model.Model;
import com.musalasoft.drone.Drone.model.State;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface DroneRepositoryImp {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "INSERT INTO drone (id, serial_number, weight_limit, battery_capacity, state, model) \n" +
            "VALUES (:id, :serialNumber, :weightLimit, :batteryCapacity, :state, :model)\n" +
            "ON CONFLICT (id) DO \n" +
            "UPDATE SET state =:state", nativeQuery = true)
    void update(long id, State state, String serialNumber, Integer weightLimit, Integer batteryCapacity, Model model);

}