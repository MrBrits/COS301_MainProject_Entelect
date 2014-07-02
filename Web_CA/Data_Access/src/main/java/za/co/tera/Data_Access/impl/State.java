package za.co.tera.Data_Access.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Christo on 2014/07/02.
 */
@Entity
public class State {
    private int stateId;
    private String stateName;
    private String stateDesc;
    private double stateValue;
    private String stateRgb;
    private int ownerId;

    @Id
    @Column(name = "StateID", nullable = false, insertable = true, updatable = true)
    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    @Basic
    @Column(name = "StateName", nullable = false, insertable = true, updatable = true, length = 20)
    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Basic
    @Column(name = "StateDesc", nullable = false, insertable = true, updatable = true, length = 100)
    public String getStateDesc() {
        return stateDesc;
    }

    public void setStateDesc(String stateDesc) {
        this.stateDesc = stateDesc;
    }

    @Basic
    @Column(name = "StateValue", nullable = false, insertable = true, updatable = true, precision = 0)
    public double getStateValue() {
        return stateValue;
    }

    public void setStateValue(double stateValue) {
        this.stateValue = stateValue;
    }

    @Basic
    @Column(name = "StateRGB", nullable = false, insertable = true, updatable = true, length = 11)
    public String getStateRgb() {
        return stateRgb;
    }

    public void setStateRgb(String stateRgb) {
        this.stateRgb = stateRgb;
    }

    @Basic
    @Column(name = "OwnerID", nullable = false, insertable = true, updatable = true)
    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        State state = (State) o;

        if (ownerId != state.ownerId) return false;
        if (stateId != state.stateId) return false;
        if (Double.compare(state.stateValue, stateValue) != 0) return false;
        if (stateDesc != null ? !stateDesc.equals(state.stateDesc) : state.stateDesc != null) return false;
        if (stateName != null ? !stateName.equals(state.stateName) : state.stateName != null) return false;
        if (stateRgb != null ? !stateRgb.equals(state.stateRgb) : state.stateRgb != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = stateId;
        result = 31 * result + (stateName != null ? stateName.hashCode() : 0);
        result = 31 * result + (stateDesc != null ? stateDesc.hashCode() : 0);
        temp = Double.doubleToLongBits(stateValue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (stateRgb != null ? stateRgb.hashCode() : 0);
        result = 31 * result + ownerId;
        return result;
    }
}
