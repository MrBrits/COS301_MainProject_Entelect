package za.co.tera.data_access.impl;

import za.co.tera.Domain.impl.Condition;
import za.co.tera.data_access.base.EntityDOA;

import java.util.List;

/**
 * Created by Laptop on 7/3/2014.
 */
public class ConditionDOA  implements EntityDOA<Condition>{
    @Override
    public void saveOrUpdate(Condition object) {

    }

    @Override
    public void delete(Condition object) {

    }

    @Override
    public Condition find(int id) {
        return new Condition();
    }

    @Override
    public List<Condition> findAllObject() {
        return null;
    }
    public void insertCondition(int stateToBeFound, int amountToBeFound,int directionId,int conditionTypeId,int ruleId)
    {
        Condition condition = new Condition(stateToBeFound,amountToBeFound,directionId,conditionTypeId,ruleId);

    }
}
