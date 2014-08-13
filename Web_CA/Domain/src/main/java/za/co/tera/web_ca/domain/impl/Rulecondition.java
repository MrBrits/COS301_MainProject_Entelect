package za.co.tera.web_ca.domain.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Christo on 2014/08/13.
 */
@Entity
public class Rulecondition {
    private int ruleConditionId;
    private boolean isNot;
    private String operation;
    private String operand;
    private int compareValue;
    private int neighboursId;

    public Rulecondition()
    {

    }

    public Rulecondition(int ruleConditionId, boolean isNot, String operation, String operand, int compareValue, int neighboursId) {
        this.ruleConditionId = ruleConditionId;
        this.isNot = isNot;
        this.operation = operation;
        this.operand = operand;
        this.compareValue = compareValue;
        this.neighboursId = neighboursId;
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
    @Column(name = "isNot", nullable = false, insertable = true, updatable = true)
    public boolean isNot() {
        return isNot;
    }

    public void setNot(boolean isNot) {
        this.isNot = isNot;
    }

    @Basic
    @Column(name = "Operation", nullable = false, insertable = true, updatable = true, length = 10)
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Basic
    @Column(name = "Operand", nullable = false, insertable = true, updatable = true, length = 2)
    public String getOperand() {
        return operand;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    @Basic
    @Column(name = "CompareValue", nullable = false, insertable = true, updatable = true)
    public int getCompareValue() {
        return compareValue;
    }

    public void setCompareValue(int compareValue) {
        this.compareValue = compareValue;
    }

    @Basic
    @Column(name = "NeighboursID", nullable = false, insertable = true, updatable = true)
    public int getNeighboursId() {
        return neighboursId;
    }

    public void setNeighboursId(int neighboursId) {
        this.neighboursId = neighboursId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rulecondition that = (Rulecondition) o;

        if (compareValue != that.compareValue) return false;
        if (isNot != that.isNot) return false;
        if (neighboursId != that.neighboursId) return false;
        if (ruleConditionId != that.ruleConditionId) return false;
        if (operand != null ? !operand.equals(that.operand) : that.operand != null) return false;
        if (operation != null ? !operation.equals(that.operation) : that.operation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ruleConditionId;
        result = 31 * result + (isNot ? 1 : 0);
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        result = 31 * result + (operand != null ? operand.hashCode() : 0);
        result = 31 * result + compareValue;
        result = 31 * result + neighboursId;
        return result;
    }
}
