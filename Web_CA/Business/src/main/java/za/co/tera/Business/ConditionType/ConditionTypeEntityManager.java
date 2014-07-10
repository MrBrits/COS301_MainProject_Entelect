package za.co.tera.Business.ConditionType;

import za.co.tera.Domain.impl.Conditiontype;
import za.co.tera.data_access.impl.ConditionTypeDAO;

import java.util.List;

/**
 * Created by Christo on 2014/07/04.
 */
public class ConditionTypeEntityManager {

    private ConditionTypeDAO conditionType = new ConditionTypeDAO();

    public void createConditionType(Conditiontype newConditionType)
    {
        conditionType.insertConditionType(newConditionType.getConditionTypeName(), newConditionType.getConditionDesc());
    }

    public void createConditionType(String conditionTypeName, String conditionTypeDesc)
    {
        conditionType.insertConditionType(conditionTypeName, conditionTypeDesc);
    }

    public void deleteConditionType(Conditiontype delConditionType)
    {
        conditionType.delete(delConditionType);
    }

    public void updateConditionType(Conditiontype updateConditionType)
    {
        conditionType.saveOrUpdate(updateConditionType);
    }

    public Conditiontype findConditionType(int ID)
    {
        return conditionType.find(ID);
    }

    public List<Conditiontype> findAllConditionTypes()
    {
        List<Conditiontype> conditionTypeList = conditionType.findAllObject();
        return  conditionTypeList;
    }
}
