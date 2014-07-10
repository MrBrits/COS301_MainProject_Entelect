package za.co.tera.Domain.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Christo on 2014/07/10.
 */
@Entity
public class Rulecondition {
    private int ruleConditionId;
    private int amountToFind;
    private int stateToFind;
    private int conditionTypeId;
    private int directionId;
    private int ruleId;

    public Rulecondition()
    {}

    public Rulecondition(int amountToFind, int stateToFind, int conditionTypeId, int directionId, int ruleId)
    {
        this.amountToFind = amountToFind;
        this.stateToFind = stateToFind;
        this.conditionTypeId = conditionTypeId;
        this.directionId = directionId;
        this.ruleId = ruleId;
    }

    @Id
    @Column(name = "RuleConditionID", nullable = false, insertable = true, updatable = true)
    public int getRuleConditionId() {
        return ruleConditionId;
    }

    public void setRuleConditionId(int ruleConditionId) {
        this.ruleConditionId = ruleConditionId;
    }

    @Basic
    @Column(name = "AmountToFind", nullable = false, insertable = true, updatable = true)
    public int getAmountToFind() {
        return amountToFind;
    }

    public void setAmountToFind(int amountToFind) {
        this.amountToFind = amountToFind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rulecondition that = (Rulecondition) o;

        if (amountToFind != that.amountToFind) return false;
        if (ruleConditionId != that.ruleConditionId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ruleConditionId;
        result = 31 * result + amountToFind;
        return result;
    }

    @Basic
    @Column(name = "StateToFind", nullable = false, insertable = true, updatable = true)
    public int getStateToFind() {
        return stateToFind;
    }

    public void setStateToFind(int stateToFind) {
        this.stateToFind = stateToFind;
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
    @Column(name = "DirectionID", nullable = false, insertable = true, updatable = true)
    public int getDirectionId() {
        return directionId;
    }

    public void setDirectionId(int directionId) {
        this.directionId = directionId;
    }

    @Basic
    @Column(name = "RuleID", nullable = false, insertable = true, updatable = true)
    public int getRuleId() {
        return ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }
}
