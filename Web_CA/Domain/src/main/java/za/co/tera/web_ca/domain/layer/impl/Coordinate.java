package za.co.tera.web_ca.domain.layer.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Laptop on 7/1/2014.
 */
@Entity
public class Coordinate {
    private int coordinateId;
    private int coordinateX;
    private int coordinateY;
    private int coordinateZ;
    private int stateId;

    @Id
    @Column(name = "CoordinateID")
    public int getCoordinateId() {
        return coordinateId;
    }

    public void setCoordinateId(int coordinateId) {
        this.coordinateId = coordinateId;
    }

    @Basic
    @Column(name = "CoordinateX")
    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    @Basic
    @Column(name = "CoordinateY")
    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    @Basic
    @Column(name = "CoordinateZ")
    public int getCoordinateZ() {
        return coordinateZ;
    }

    public void setCoordinateZ(int coordinateZ) {
        this.coordinateZ = coordinateZ;
    }

    @Basic
    @Column(name = "StateID")
    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
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
        if (stateId != that.stateId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = coordinateId;
        result = 31 * result + coordinateX;
        result = 31 * result + coordinateY;
        result = 31 * result + coordinateZ;
        result = 31 * result + stateId;
        return result;
    }
}
