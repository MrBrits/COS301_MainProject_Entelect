package za.co.tera.Domain.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Christo on 2014/07/10.
 */
@Entity
public class Direction {
    private int directionId;
    private String directionDesc;

    public Direction(){
    }

    public Direction(String directionDesc)
    {
        this.directionDesc = directionDesc;
    }

    @Id
    @Column(name = "DirectionID", nullable = false, insertable = true, updatable = true)
    public int getDirectionId() {
        return directionId;
    }

    public void setDirectionId(int directionId) {
        this.directionId = directionId;
    }

    @Basic
    @Column(name = "DirectionDesc", nullable = false, insertable = true, updatable = true, length = 28)
    public String getDirectionDesc() {
        return directionDesc;
    }

    public void setDirectionDesc(String directionDesc) {
        this.directionDesc = directionDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction = (Direction) o;

        if (directionId != direction.directionId) return false;
        if (directionDesc != null ? !directionDesc.equals(direction.directionDesc) : direction.directionDesc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = directionId;
        result = 31 * result + (directionDesc != null ? directionDesc.hashCode() : 0);
        return result;
    }
}
