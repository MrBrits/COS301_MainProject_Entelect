package za.co.tera.web_ca.domain.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Laptop on 7/14/2014.
 */
@Entity
public class Worldrules implements Serializable{
    private int worldRulesId;
    private int worldId;
    private int ruleId;

    @Id
    @Column(name = "WorldRulesID", nullable = false, insertable = true, updatable = true)
    public int getWorldRulesId() {
        return worldRulesId;
    }

    public void setWorldRulesId(int worldRulesId) {
        this.worldRulesId = worldRulesId;
    }

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
        if (worldRulesId != that.worldRulesId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = worldRulesId;
        result = 31 * result + worldId;
        result = 31 * result + ruleId;
        return result;
    }
}
