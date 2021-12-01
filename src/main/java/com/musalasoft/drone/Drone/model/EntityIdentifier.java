package com.musalasoft.drone.Drone.model;

import java.io.Serializable;

public interface EntityIdentifier extends Serializable {

    /**
     * Sets the entity Id
     * @param id the entity ID
     */
    void setId(long id);

    /**
     * returns the entity Id
     */
    long getId();
}
