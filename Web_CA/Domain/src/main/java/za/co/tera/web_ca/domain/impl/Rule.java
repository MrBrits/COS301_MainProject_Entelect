package za.co.tera.web_ca.domain.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Rule implements Serializable {
    private int ruleId;
    private String ruleName;
    private String ruleDesc;
    private int ruleConId;
    private Integer ruleConAndid;
    private Integer ruleConOrid;
    private Integer ruleResId;
    private int ownerId;

    public Rule() {
    }

    public Rule(String ruleName, String ruleDesc, int ruleConId, Integer ruleConAndid, Integer ruleConOrid, Integer ruleResId, int ownerId) {
        this.ruleName = ruleName;
        this.ruleDesc = ruleDesc;
        this.ruleConId = ruleConId;
        this.ruleConAndid = ruleConAndid;
        this.ruleConOrid = ruleConOrid;
        this.ruleResId = ruleResId;
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
    @Column(name = "RuleConID", nullable = false, insertable = true, updatable = true)
    public int getRuleConId() {
        return ruleConId;
    }

    public void setRuleConId(int ruleConId) {
        this.ruleConId = ruleConId;
    }

    @Basic
    @Column(name = "RuleConANDID", nullable = true, insertable = true, updatable = true)
    public Integer getRuleConAndid() {
        return ruleConAndid;
    }

    public void setRuleConAndid(Integer ruleConAndid) {
        this.ruleConAndid = ruleConAndid;
    }

    @Basic
    @Column(name = "RuleConORID", nullable = true, insertable = true, updatable = true)
    public Integer getRuleConOrid() {
        return ruleConOrid;
    }

    public void setRuleConOrid(Integer ruleConOrid) {
        this.ruleConOrid = ruleConOrid;
    }

    @Basic
    @Column(name = "RuleResID", nullable = true, insertable = true, updatable = true)
    public Integer getRuleResId() {
        return ruleResId;
    }

    public void setRuleResId(Integer ruleResId) {
        this.ruleResId = ruleResId;
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
        if (ruleConId != rule.ruleConId) return false;
        if (ruleId != rule.ruleId) return false;
        if (ruleConAndid != null ? !ruleConAndid.equals(rule.ruleConAndid) : rule.ruleConAndid != null) return false;
        if (ruleConOrid != null ? !ruleConOrid.equals(rule.ruleConOrid) : rule.ruleConOrid != null) return false;
        if (ruleDesc != null ? !ruleDesc.equals(rule.ruleDesc) : rule.ruleDesc != null) return false;
        if (ruleName != null ? !ruleName.equals(rule.ruleName) : rule.ruleName != null) return false;
        if (ruleResId != null ? !ruleResId.equals(rule.ruleResId) : rule.ruleResId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ruleId;
        result = 31 * result + (ruleName != null ? ruleName.hashCode() : 0);
        result = 31 * result + (ruleDesc != null ? ruleDesc.hashCode() : 0);
        result = 31 * result + ruleConId;
        result = 31 * result + (ruleConAndid != null ? ruleConAndid.hashCode() : 0);
        result = 31 * result + (ruleConOrid != null ? ruleConOrid.hashCode() : 0);
        result = 31 * result + (ruleResId != null ? ruleResId.hashCode() : 0);
        result = 31 * result + ownerId;
        return result;
    }
}
