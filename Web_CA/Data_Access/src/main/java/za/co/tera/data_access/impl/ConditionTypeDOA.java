package za.co.tera.data_access.impl;

import za.co.tera.Domain.impl.Conditiontype;
import za.co.tera.data_access.base.EntityDOA;

import java.util.List;

/**
 * Created by Laptop on 7/3/2014.
 */
public class ConditionTypeDOA implements EntityDOA<Conditiontype>{
    @Override
    public void saveOrUpdate(Conditiontype object) {

    }

    @Override
    public void delete(Conditiontype object) {

    }

    @Override
    public Conditiontype find(int id) {
        return new Conditiontype();
    }

    @Override
    public List<Conditiontype> findAllObject() {
        return null;
    }

    public void insertConditionType(String conditionName,String conditionDesc)
    {
        Conditiontype conditiontype = new Conditiontype(conditionName,conditionDesc);

    }
}
