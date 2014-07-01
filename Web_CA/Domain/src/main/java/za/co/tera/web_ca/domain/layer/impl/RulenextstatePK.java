package za.co.tera.web_ca.domain.layer.impl;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Laptop on 7/1/2014.
 */
public class RulenextstatePK implements Serializable {
    private int ruleId;
    private int stateId;

    @Column(name = "RuleID")
    @Id
    public int getRuleId() {
        return ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    @Column(name = "StateID")
    @Id
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

        RulenextstatePK that = (RulenextstatePK) o;

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
