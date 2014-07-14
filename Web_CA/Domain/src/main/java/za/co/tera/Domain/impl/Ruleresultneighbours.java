package za.co.tera.Domain.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Christo on 2014/07/14.
 */
@Entity
public class Ruleresultneighbours {
    private int ruleResultNeighId;
    private String neighbours;
    private int ruleResultId;

    @Id
    @Column(name = "RuleResultNeighID", nullable = false, insertable = true, updatable = true)
    public int getRuleResultNeighId() {
        return ruleResultNeighId;
    }

    public void setRuleResultNeighId(int ruleResultNeighId) {
        this.ruleResultNeighId = ruleResultNeighId;
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
    @Column(name = "RuleResultID", nullable = false, insertable = true, updatable = true)
    public int getRuleResultId() {
        return ruleResultId;
    }

    public void setRuleResultId(int ruleResultId) {
        this.ruleResultId = ruleResultId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ruleresultneighbours that = (Ruleresultneighbours) o;

        if (ruleResultId != that.ruleResultId) return false;
        if (ruleResultNeighId != that.ruleResultNeighId) return false;
        if (neighbours != null ? !neighbours.equals(that.neighbours) : that.neighbours != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ruleResultNeighId;
        result = 31 * result + (neighbours != null ? neighbours.hashCode() : 0);
        result = 31 * result + ruleResultId;
        return result;
    }
}
