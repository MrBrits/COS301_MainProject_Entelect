package za.co.tera.Domain.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Christo on 2014/07/02.
 */
@Entity
public class Rule {
    private int ruleId;
    private String ruleName;
    private String ruleDesc;
    private int priority;
    private int conditionId;
    private int currentValue;
    private int nextValue;
    private int ownerId;

    @Id
    @Column(name = "RuleID", nullable = false, insertable = true, updatable = true)
    public int getRuleId() {
        return ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    @Basic
    @Column(name = "RuleName", nullable = false, insertable = true, updatable = true, length = 20)
    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    @Basic
    @Column(name = "RuleDesc", nullable = false, insertable = true, updatable = true, length = 100)
    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }

    @Basic
    @Column(name = "Priority", nullable = false, insertable = true, updatable = true)
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Basic
    @Column(name = "ConditionID", nullable = false, insertable = true, updatable = true)
    public int getConditionId() {
        return conditionId;
    }

    public void setConditionId(int conditionId) {
        this.conditionId = conditionId;
    }

    @Basic
    @Column(name = "CurrentValue", nullable = false, insertable = true, updatable = true)
    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    @Basic
    @Column(name = "NextValue", nullable = false, insertable = true, updatable = true)
    public int getNextValue() {
        return nextValue;
    }

    public void setNextValue(int nextValue) {
        this.nextValue = nextValue;
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

        Rule rule = (Rule) o;

        if (conditionId != rule.conditionId) return false;
        if (currentValue != rule.currentValue) return false;
        if (nextValue != rule.nextValue) return false;
        if (ownerId != rule.ownerId) return false;
        if (priority != rule.priority) return false;
        if (ruleId != rule.ruleId) return false;
        if (ruleDesc != null ? !ruleDesc.equals(rule.ruleDesc) : rule.ruleDesc != null) return false;
        if (ruleName != null ? !ruleName.equals(rule.ruleName) : rule.ruleName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ruleId;
        result = 31 * result + (ruleName != null ? ruleName.hashCode() : 0);
        result = 31 * result + (ruleDesc != null ? ruleDesc.hashCode() : 0);
        result = 31 * result + priority;
        result = 31 * result + conditionId;
        result = 31 * result + currentValue;
        result = 31 * result + nextValue;
        result = 31 * result + ownerId;
        return result;
    }
}
