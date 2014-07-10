package za.co.tera.Business.ConditionType;

import za.co.tera.Domain.impl.Conditiontype;
import za.co.tera.data_access.impl.ConditionTypeDAO;

import java.util.List;

/**
 * Created by Christo on 2014/07/04.
 */
public class ConditionTypeEntityManager {

    private ConditionTypeDAO conditionTypeDAO = new ConditionTypeDAO();

    public void createConditionType(Conditiontype newConditionType)
    {
        conditionTypeDAO.insertConditionType(newConditionType.getConditionTypeName(), newConditionType.getConditionDesc());
    }

    public void createConditionType(String conditionTypeName, String conditionTypeDesc)
    {
        conditionTypeDAO.insertConditionType(conditionTypeName, conditionTypeDesc);
    }

    public void deleteConditionType(Conditiontype delConditionType)
    {
        conditionTypeDAO.delete(delConditionType);
    }

    public void updateConditionType(Conditiontype updateConditionType)
    {
        conditionTypeDAO.saveOrUpdate(updateConditionType);
    }

    public Conditiontype findConditionType(int ID)
    {
        return conditionTypeDAO.find(ID);
    }

    public List<Conditiontype> findAllConditionTypes()
    {
        List<Conditiontype> conditionTypeList = conditionTypeDAO.findAllObject();
        return  conditionTypeList;
    }
}
