package za.co.tera.web_ca.domain.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Rulecondition implements Serializable {
    private int ruleConditionId;
    private boolean isNot;
    private String operation;
    private int neighboursId;
    private String operand;
    private double compareValueOne;
    private Double compareValueTwo;

    public Rulecondition() {
    }

    public Rulecondition(boolean isNot, String operation, int neighboursId, String operand, double compareValueOne, Double compareValueTwo) {
        this.isNot = isNot;
        this.operation = operation;
        this.neighboursId = neighboursId;
        this.operand = operand;
        this.compareValueOne = compareValueOne;
        this.compareValueTwo = compareValueTwo;
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
    @Column(name = "NeighboursID", nullable = false, insertable = true, updatable = true)
    public int getNeighboursId() {
        return neighboursId;
    }

    public void setNeighboursId(int neighboursId) {
        this.neighboursId = neighboursId;
    }

    @Basic
    @Column(name = "Operand", nullable = false, insertable = true, updatable = true, length = 7)
    public String getOperand() {
        return operand;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    @Basic
    @Column(name = "CompareValueOne", nullable = false, insertable = true, updatable = true, precision = 0)
    public double getCompareValueOne() {
        return compareValueOne;
    }

    public void setCompareValueOne(double compareValueOne) {
        this.compareValueOne = compareValueOne;
    }

    @Basic
    @Column(name = "CompareValueTwo", nullable = true, insertable = true, updatable = true, precision = 0)
    public Double getCompareValueTwo() {
        return compareValueTwo;
    }

    public void setCompareValueTwo(Double compareValueTwo) {
        this.compareValueTwo = compareValueTwo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rulecondition that = (Rulecondition) o;

        if (Double.compare(that.compareValueOne, compareValueOne) != 0) return false;
        if (isNot != that.isNot) return false;
        if (neighboursId != that.neighboursId) return false;
        if (ruleConditionId != that.ruleConditionId) return false;
        if (compareValueTwo != null ? !compareValueTwo.equals(that.compareValueTwo) : that.compareValueTwo != null)
            return false;
        if (operand != null ? !operand.equals(that.operand) : that.operand != null) return false;
        if (operation != null ? !operation.equals(that.operation) : that.operation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = ruleConditionId;
        result = 31 * result + (isNot ? 1 : 0);
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        result = 31 * result + neighboursId;
        result = 31 * result + (operand != null ? operand.hashCode() : 0);
        temp = Double.doubleToLongBits(compareValueOne);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (compareValueTwo != null ? compareValueTwo.hashCode() : 0);
        return result;
    }
}
