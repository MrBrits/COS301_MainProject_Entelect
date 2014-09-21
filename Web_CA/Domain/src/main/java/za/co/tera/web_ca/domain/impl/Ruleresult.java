package za.co.tera.web_ca.domain.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Stephan on 9/21/2014.
 */
@Entity
public class Ruleresult implements Serializable {
    private int ruleResultId;
    private String operation;
    private String operand;
    private Double resultValue;
    public Ruleresult()
    {}
    public Ruleresult(String operation, String operand, Double resultValue) {
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
    @Column(name = "Operation", nullable = true, insertable = true, updatable = true, length = 10)
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Basic
    @Column(name = "Operand", nullable = false, insertable = true, updatable = true, length = 10)
    public String getOperand() {
        return operand;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    @Basic
    @Column(name = "ResultValue", nullable = true, insertable = true, updatable = true, precision = 0)
    public Double getResultValue() {
        return resultValue;
    }

    public void setResultValue(Double resultValue) {
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
