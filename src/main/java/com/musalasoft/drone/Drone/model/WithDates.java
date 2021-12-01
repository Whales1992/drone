package com.musalasoft.drone.Drone.model;

import java.io.Serializable;
import java.time.OffsetDateTime;

public interface WithDates extends Serializable {

    /**
     * Sets the entity create date
     * @param createdDate the date the entity was created
     */
    void setCreatedDate(OffsetDateTime createdDate);

    /**
     * returns the created date of the entity
     */
    OffsetDateTime getCreatedDate();

    /**
     * Updates the entity date
     * @param updatedDate the date the entity was updated
     */
    void setUpdatedDate(OffsetDateTime updatedDate);

    /**
     * Returns the entity update date
     */
    OffsetDateTime getUpdatedDate();
}
