package za.co.tera.Domain.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Christo on 2014/07/14.
 */
@Entity
public class Worldrules {
    private int worldId;
    private int ruleId;

    @Basic
    @Column(name = "WorldID", nullable = false, insertable = true, updatable = true)
    public int getWorldId() {
        return worldId;
    }

    public void setWorldId(int worldId) {
        this.worldId = worldId;
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

        Worldrules that = (Worldrules) o;

        if (ruleId != that.ruleId) return false;
        if (worldId != that.worldId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = worldId;
        result = 31 * result + ruleId;
        return result;
    }
}
