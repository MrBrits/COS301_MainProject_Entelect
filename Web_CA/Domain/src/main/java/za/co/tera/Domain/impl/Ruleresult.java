package za.co.tera.Domain.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Christo on 2014/07/14.
 */
@Entity
public class Ruleresult {
    private int ruleResultId;
    private String operation;
    private String operand;
    private Integer resultValue;

    public Ruleresult()
    {}

    public Ruleresult(String operation, String operand, int resultValue)
    {
        this.operation = operation;
        this.operand = operand;
        this.resultValue = resultValue;
    }

    @Id
    @Column(name = "RuleResultID", nullable = false, insertable = true, updatable = true)
    public int getRuleResultId() {
        return ruleResultId;
    }

    public void setRuleResultId(int ruleResultId) {
        this.ruleResultId = ruleResultId;
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
    @Column(name = "ResultValue", nullable = true, insertable = true, updatable = true)
    public Integer getResultValue() {
        return resultValue;
    }

    public void setResultValue(Integer resultValue) {
        this.resultValue = resultValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ruleresult that = (Ruleresult) o;

        if (ruleResultId != that.ruleResultId) return false;
        if (operand != null ? !operand.equals(that.operand) : that.operand != null) return false;
        if (operation != null ? !operation.equals(that.operation) : that.operation != null) return false;
        if (resultValue != null ? !resultValue.equals(that.resultValue) : that.resultValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ruleResultId;
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        result = 31 * result + (operand != null ? operand.hashCode() : 0);
        result = 31 * result + (resultValue != null ? resultValue.hashCode() : 0);
        return result;
    }
}
