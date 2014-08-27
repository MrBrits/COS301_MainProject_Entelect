package za.co.tera.web_ca.domain.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Coordinate implements Serializable{
    private int coordinateId;
    private int coordinateX;
    private int coordinateY;
    private int coordinateZ;
    private double stateValue;
    private int worldId;

    public Coordinate()
    {}

    public Coordinate(int coordinateX, int coordinateY, int coordinateZ, double stateValue, int worldId)
    {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.coordinateZ = coordinateZ;
        this.stateValue = stateValue;
        this.worldId = worldId;
    }

    @Id
    @Column(name = "CoordinateID", nullable = false, insertable = true, updatable = true)
    public int getCoordinateId() {
        return coordinateId;
    }

    public void setCoordinateId(int coordinateId) {
        this.coordinateId = coordinateId;
    }

    @Basic
    @Column(name = "CoordinateX", nullable = false, insertable = true, updatable = true)
    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    @Basic
    @Column(name = "CoordinateY", nullable = false, insertable = true, updatable = true)
    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    @Basic
    @Column(name = "CoordinateZ", nullable = false, insertable = true, updatable = true)
    public int getCoordinateZ() {
        return coordinateZ;
    }

    public void setCoordinateZ(int coordinateZ) {
        this.coordinateZ = coordinateZ;
    }

    @Basic
    @Column(name = "StateValue", nullable = false, insertable = true, updatable = true)
    public double getValue() {
        return stateValue;
    }

    public void setValue(double stateValue) {
        this.stateValue = stateValue;
    }

    @Basic
    @Column(name = "WorldID", nullable = false, insertable = true, updatable = true)
    public int getWorldId() {
        return worldId;
    }

    public void setWorldId(int worldId) {
        this.worldId = worldId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (coordinateId != that.coordinateId) return false;
        if (coordinateX != that.coordinateX) return false;
        if (coordinateY != that.coordinateY) return false;
        if (coordinateZ != that.coordinateZ) return false;
        if (stateValue != that.stateValue) return false;
        if (worldId != that.worldId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = coordinateId;
        long temp;
        result = 31 * result + coordinateX;
        result = 31 * result + coordinateY;
        result = 31 * result + coordinateZ;
        temp = Double.doubleToLongBits(stateValue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + worldId;
        return result;
    }
}
