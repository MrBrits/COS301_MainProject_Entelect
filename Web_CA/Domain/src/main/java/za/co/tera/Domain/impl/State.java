package za.co.tera.Domain.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Christo on 2014/07/14.
 */
@Entity
public class State {
    private int stateId;
    private String stateName;
    private String stateDesc;
    private int stateValue;
    private String stateHex;
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
    @Column(name = "StateDesc", nullable = false, insertable = true, updatable = true, length = 300)
    public String getStateDesc() {
        return stateDesc;
    }

    public void setStateDesc(String stateDesc) {
        this.stateDesc = stateDesc;
    }

    @Basic
    @Column(name = "StateValue", nullable = false, insertable = true, updatable = true)
    public int getStateValue() {
        return stateValue;
    }

    public void setStateValue(int stateValue) {
        this.stateValue = stateValue;
    }

    @Basic
    @Column(name = "StateHex", nullable = false, insertable = true, updatable = true, length = 7)
    public String getStateHex() {
        return stateHex;
    }

    public void setStateHex(String stateHex) {
        this.stateHex = stateHex;
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
        if (stateValue != state.stateValue) return false;
        if (stateDesc != null ? !stateDesc.equals(state.stateDesc) : state.stateDesc != null) return false;
        if (stateHex != null ? !stateHex.equals(state.stateHex) : state.stateHex != null) return false;
        if (stateName != null ? !stateName.equals(state.stateName) : state.stateName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stateId;
        result = 31 * result + (stateName != null ? stateName.hashCode() : 0);
        result = 31 * result + (stateDesc != null ? stateDesc.hashCode() : 0);
        result = 31 * result + stateValue;
        result = 31 * result + (stateHex != null ? stateHex.hashCode() : 0);
        result = 31 * result + ownerId;
        return result;
    }
}
