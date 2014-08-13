package za.co.tera.web_ca.domain.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Christo on 2014/08/13.
 */
@Entity
public class Ruleresultneighbours {
    private int ruleResultNeighId;
    private String neighbours;

    public Ruleresultneighbours() {
    }

    public Ruleresultneighbours(int ruleResultNeighId, String neighbours) {
        this.ruleResultNeighId = ruleResultNeighId;
        this.neighbours = neighbours;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ruleresultneighbours that = (Ruleresultneighbours) o;

        if (ruleResultNeighId != that.ruleResultNeighId) return false;
        if (neighbours != null ? !neighbours.equals(that.neighbours) : that.neighbours != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ruleResultNeighId;
        result = 31 * result + (neighbours != null ? neighbours.hashCode() : 0);
        return result;
    }
}
