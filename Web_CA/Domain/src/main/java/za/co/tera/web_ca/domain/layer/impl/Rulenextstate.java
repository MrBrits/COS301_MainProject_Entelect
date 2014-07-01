package za.co.tera.web_ca.domain.layer.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created by Laptop on 7/1/2014.
 */
@Entity
@IdClass(RulenextstatePK.class)
public class Rulenextstate {
    private int ruleId;
    private int stateId;

    @Id
    @Column(name = "RuleID")
    public int getRuleId() {
        return ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    @Id
    @Column(name = "StateID")
    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rulenextstate that = (Rulenextstate) o;

        if (ruleId != that.ruleId) return false;
        if (stateId != that.stateId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ruleId;
        result = 31 * result + stateId;
        return result;
    }
}
