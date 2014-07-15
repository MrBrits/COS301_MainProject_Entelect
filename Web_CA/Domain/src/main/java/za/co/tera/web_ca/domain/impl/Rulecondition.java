package za.co.tera.web_ca.domain.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Christo on 2014/07/14.
 */
@Entity
public class Rulecondition  implements Serializable {
    private int ruleConditionId;
    private byte isNot;
    private String operation;
    private String operand;
    private int compareValue;

    public Rulecondition()
    {}

    public Rulecondition(byte isNot, String operation, String operand, int compareValue)
    {
        this.isNot = isNot;
        this.operation = operation;
        this.operand = operand;
        this.compareValue = compareValue;
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
    public byte getIsNot() {
        return isNot;
    }

    public void setIsNot(byte isNot) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rulecondition that = (Rulecondition) o;

        if (compareValue != that.compareValue) return false;
        if (isNot != that.isNot) return false;
        if (ruleConditionId != that.ruleConditionId) return false;
        if (operand != null ? !operand.equals(that.operand) : that.operand != null) return false;
        if (operation != null ? !operation.equals(that.operation) : that.operation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ruleConditionId;
        result = 31 * result + (int) isNot;
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        result = 31 * result + (operand != null ? operand.hashCode() : 0);
        result = 31 * result + compareValue;
        return result;
    }
}