package za.co.tera.Domain.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Christo on 2014/07/14.
 */
@Entity
public class Ruleconditionneighbours {
    private int ruleConditionNeighId;
    private String neighbours;
    private int ruleConditionId;

    public Ruleconditionneighbours()
    {}

    public  Ruleconditionneighbours(String neighbours, int ruleConditionId)
    {
        this.neighbours = neighbours;
        this.ruleConditionId = ruleConditionId;
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

    @Basic
    @Column(name = "RuleConditionID", nullable = false, insertable = true, updatable = true)
    public int getRuleConditionId() {
        return ruleConditionId;
    }

    public void setRuleConditionId(int ruleConditionId) {
        this.ruleConditionId = ruleConditionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ruleconditionneighbours that = (Ruleconditionneighbours) o;

        if (ruleConditionId != that.ruleConditionId) return false;
        if (ruleConditionNeighId != that.ruleConditionNeighId) return false;
        if (neighbours != null ? !neighbours.equals(that.neighbours) : that.neighbours != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ruleConditionNeighId;
        result = 31 * result + (neighbours != null ? neighbours.hashCode() : 0);
        result = 31 * result + ruleConditionId;
        return result;
    }
}
