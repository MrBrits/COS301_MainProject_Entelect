package za.co.tera.web_ca.domain.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Christo on 2014/08/13.
 */
@Entity
public class Ruleconditionneighbours {
    private int ruleConditionNeighId;
    private String neighbours;

    public Ruleconditionneighbours() {
    }

    public Ruleconditionneighbours(int ruleConditionNeighId, String neighbours) {
        this.ruleConditionNeighId = ruleConditionNeighId;
        this.neighbours = neighbours;
    }

    @Id
    @Column(name = "RuleConditionNeighID", nullable = false, insertable = true, updatable = true)
    public int getRuleConditionNeighId() {
        return ruleConditionNeighId;
    }

    public void setRuleConditionNeighId(int ruleConditionNeighId) {
        this.ruleConditionNeighId = ruleConditionNeighId;
    }

    @Basic
    @Column(name = "Neighbours", nullable = false, insertable = true, updatable = true, length = 26)
    public String getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(String neighbours) {
        this.neighbours = neighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ruleconditionneighbours that = (Ruleconditionneighbours) o;

        if (ruleConditionNeighId != that.ruleConditionNeighId) return false;
        if (neighbours != null ? !neighbours.equals(that.neighbours) : that.neighbours != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ruleConditionNeighId;
        result = 31 * result + (neighbours != null ? neighbours.hashCode() : 0);
        return result;
    }
}
