package za.co.tera.web_ca.domain.layer.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Laptop on 7/1/2014.
 */
@Entity
public class Conditiontype {
    private int conditionTypeId;
    private String conditionName;
    private String conditionDesc;

    @Id
    @Column(name = "ConditionTypeID")
    public int getConditionTypeId() {
        return conditionTypeId;
    }

    public void setConditionTypeId(int conditionTypeId) {
        this.conditionTypeId = conditionTypeId;
    }

    @Basic
    @Column(name = "ConditionName")
    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    @Basic
    @Column(name = "ConditionDesc")
    public String getConditionDesc() {
        return conditionDesc;
    }

    public void setConditionDesc(String conditionDesc) {
        this.conditionDesc = conditionDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conditiontype that = (Conditiontype) o;

        if (conditionTypeId != that.conditionTypeId) return false;
        if (conditionDesc != null ? !conditionDesc.equals(that.conditionDesc) : that.conditionDesc != null)
            return false;
        if (conditionName != null ? !conditionName.equals(that.conditionName) : that.conditionName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = conditionTypeId;
        result = 31 * result + (conditionName != null ? conditionName.hashCode() : 0);
        result = 31 * result + (conditionDesc != null ? conditionDesc.hashCode() : 0);
        return result;
    }
}
