package za.co.tera.web_ca.domain.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Ruleneighbours implements Serializable {
    private int ruleNeighboursId;
    private String neighbours;

    public Ruleneighbours() {
    }

    public Ruleneighbours(String neighbours) {
        this.neighbours = neighbours;
    }

    @Id
    @Column(name = "RuleNeighboursID", nullable = false, insertable = true, updatable = true)
    public int getRuleNeighboursId() {
        return ruleNeighboursId;
    }

    public void setRuleNeighboursId(int ruleNeighboursId) {
        this.ruleNeighboursId = ruleNeighboursId;
    }

    @Basic
    @Column(name = "Neighbours", nullable = false, insertable = true, updatable = true, length = 27)
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

        Ruleneighbours that = (Ruleneighbours) o;

        if (ruleNeighboursId != that.ruleNeighboursId) return false;
        if (neighbours != null ? !neighbours.equals(that.neighbours) : that.neighbours != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ruleNeighboursId;
        result = 31 * result + (neighbours != null ? neighbours.hashCode() : 0);
        return result;
    }
}
