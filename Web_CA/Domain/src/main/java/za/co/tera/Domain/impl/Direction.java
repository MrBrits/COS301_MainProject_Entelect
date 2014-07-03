package za.co.tera.Domain.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Christo on 2014/07/03.
 */
@Entity
public class Direction {
    private int directionId;
    private String directionName;

    @Id
    @Column(name = "DirectionID", nullable = false, insertable = true, updatable = true)
    public int getDirectionId() {
        return directionId;
    }

    public void setDirectionId(int directionId) {
        this.directionId = directionId;
    }

    @Basic
    @Column(name = "DirectionName", nullable = false, insertable = true, updatable = true, length = 20)
    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction = (Direction) o;

        if (directionId != direction.directionId) return false;
        if (directionName != null ? !directionName.equals(direction.directionName) : direction.directionName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = directionId;
        result = 31 * result + (directionName != null ? directionName.hashCode() : 0);
        return result;
    }
}
