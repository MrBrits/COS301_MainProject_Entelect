package za.co.tera.web_ca.domain.layer.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Laptop on 7/1/2014.
 */
@Entity
public class Direction {
    private int directionId;
    private int directionName;

    @Id
    @Column(name = "DirectionID")
    public int getDirectionId() {
        return directionId;
    }

    public void setDirectionId(int directionId) {
        this.directionId = directionId;
    }

    @Basic
    @Column(name = "DirectionName")
    public int getDirectionName() {
        return directionName;
    }

    public void setDirectionName(int directionName) {
        this.directionName = directionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction = (Direction) o;

        if (directionId != direction.directionId) return false;
        if (directionName != direction.directionName) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = directionId;
        result = 31 * result + directionName;
        return result;
    }
}
