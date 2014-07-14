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
public class Rule  implements Serializable {
    private int ruleId;
    private String ruleName;
    private String ruleDesc;
    private int priority;
    private int ruleConditionId;
    private int ruleResultId;
    private int ownerId;

    public Rule()
    {}

    public Rule(String ruleName, String ruleDesc, int priority, int ruleConditionId, int ruleResultId, int ownerId)
    {
        this.ruleName = ruleName;
        this.ruleDesc = ruleDesc;
        this.priority = priority;
        this.ruleConditionId = ruleConditionId;
        this.ruleResultId = ruleResultId;
        this.ownerId = ownerId;
    }

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
    @Column(name = "RuleDesc", nullable = false, insertable = true, updatable = true, length = 300)
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
    @Column(name = "RuleConditionID", nullable = false, insertable = true, updatable = true)
    public int getRuleConditionId() {
        return ruleConditionId;
    }

    public void setRuleConditionId(int ruleConditionId) {
        this.ruleConditionId = ruleConditionId;
    }

    @Basic
    @Column(name = "RuleResultID", nullable = false, insertable = true, updatable = true)
    public int getRuleResultId() {
        return ruleResultId;
    }

    public void setRuleResultId(int ruleResultId) {
        this.ruleResultId = ruleResultId;
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

        if (ownerId != rule.ownerId) return false;
        if (priority != rule.priority) return false;
        if (ruleConditionId != rule.ruleConditionId) return false;
        if (ruleId != rule.ruleId) return false;
        if (ruleResultId != rule.ruleResultId) return false;
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
        result = 31 * result + ruleConditionId;
        result = 31 * result + ruleResultId;
        result = 31 * result + ownerId;
        return result;
    }
}
