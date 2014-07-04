package za.co.tera.Domain.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Laptop on 7/4/2014.
 */
@Entity
public class Condition {
    private int conditionId;
    private int stateToBeFound;
    private int amountToBeFound;
    private int directionId;
    private int conditionTypeId;
    private int ruleId;
    public Condition()
    {}
    public Condition(int stateToBeFound,int amountToBeFound,int directionId,int conditionTypeId,int ruleId)
    {

        this.stateToBeFound=stateToBeFound;
        this.amountToBeFound=amountToBeFound;
        this.directionId=directionId;
        this.conditionTypeId=conditionTypeId;
        this.ruleId=ruleId;
    }
    @Id
    @Column(name = "ConditionID", nullable = false, insertable = true, updatable = true)
    public int getConditionId() {
        return conditionId;
    }

    public void setConditionId(int conditionId) {
        this.conditionId = conditionId;
    }

    @Basic
    @Column(name = "StateToBeFound", nullable = false, insertable = true, updatable = true)
    public int getStateToBeFound() {
        return stateToBeFound;
    }

    public void setStateToBeFound(int stateToBeFound) {
        this.stateToBeFound = stateToBeFound;
    }

    @Basic
    @Column(name = "AmountToBeFound", nullable = false, insertable = true, updatable = true)
    public int getAmountToBeFound() {
        return amountToBeFound;
    }

    public void setAmountToBeFound(int amountToBeFound) {
        this.amountToBeFound = amountToBeFound;
    }

    @Basic
    @Column(name = "DirectionID", nullable = false, insertable = true, updatable = true)
    public int getDirectionId() {
        return directionId;
    }

    public void setDirectionId(int directionId) {
        this.directionId = directionId;
    }

    @Basic
    @Column(name = "ConditionTypeID", nullable = false, insertable = true, updatable = true)
    public int getConditionTypeId() {
        return conditionTypeId;
    }

    public void setConditionTypeId(int conditionTypeId) {
        this.conditionTypeId = conditionTypeId;
    }

    @Basic
    @Column(name = "RuleID", nullable = false, insertable = true, updatable = true)
    public int getRuleId() {
        return ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Condition condition = (Condition) o;

        if (amountToBeFound != condition.amountToBeFound) return false;
        if (conditionId != condition.conditionId) return false;
        if (conditionTypeId != condition.conditionTypeId) return false;
        if (directionId != condition.directionId) return false;
        if (ruleId != condition.ruleId) return false;
        if (stateToBeFound != condition.stateToBeFound) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = conditionId;
        result = 31 * result + stateToBeFound;
        result = 31 * result + amountToBeFound;
        result = 31 * result + directionId;
        result = 31 * result + conditionTypeId;
        result = 31 * result + ruleId;
        return result;
    }
}
