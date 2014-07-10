package za.co.tera.Domain.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Christo on 2014/07/03.
 */
@Entity
public class Conditiontype {
    private int conditionTypeId;
    private String conditionTypeName;
    private String conditionTypeDesc;
    public Conditiontype()
    {}
    public Conditiontype(String conditionTypeName,String conditionTypeDesc)
    {
        this.conditionTypeName=conditionTypeName;
        this.conditionTypeDesc=conditionTypeDesc;
    }
    @Id
    @Column(name = "ConditionTypeID", nullable = false, insertable = true, updatable = true)
    public int getConditionTypeId() {
        return conditionTypeId;
    }

    public void setConditionTypeId(int conditionTypeId) {
        this.conditionTypeId = conditionTypeId;
    }

    @Basic
    @Column(name = "ConditionTypeName", nullable = false, insertable = true, updatable = true, length = 20)
    public String getConditionTypeName() {
        return conditionTypeName;
    }

    public void setConditionTypeName(String conditionName) {
        this.conditionTypeName = conditionName;
    }

    @Basic
    @Column(name = "ConditionTypeDesc", nullable = false, insertable = true, updatable = true, length = 100)
    public String getConditionDesc() {
        return conditionTypeDesc;
    }

    public void setConditionDesc(String conditionDesc) {
        this.conditionTypeDesc = conditionDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conditiontype that = (Conditiontype) o;

        if (conditionTypeId != that.conditionTypeId) return false;
        if (conditionTypeDesc != null ? !conditionTypeDesc.equals(that.conditionTypeDesc) : that.conditionTypeDesc != null)
            return false;
        if (conditionTypeName != null ? !conditionTypeName.equals(that.conditionTypeName) : that.conditionTypeName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = conditionTypeId;
        result = 31 * result + (conditionTypeName != null ? conditionTypeName.hashCode() : 0);
        result = 31 * result + (conditionTypeDesc != null ? conditionTypeDesc.hashCode() : 0);
        return result;
    }
}
