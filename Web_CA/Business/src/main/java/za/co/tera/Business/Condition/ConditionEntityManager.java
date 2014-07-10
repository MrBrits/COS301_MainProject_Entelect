package za.co.tera.Business.Condition;

import za.co.tera.Domain.impl.Condition;
import za.co.tera.data_access.impl.ConditionDAO;

import java.util.List;

/**
 * Created by Christo on 2014/07/04.
 */
public class ConditionEntityManager {

    private ConditionDAO condition = new ConditionDAO();

    public void createCondition(Condition newCondition)
    {
        condition.insertCondition(newCondition.getStateToBeFound(), newCondition.getAmountToBeFound(), newCondition.getDirectionId(), newCondition.getConditionTypeId(), newCondition.getRuleId());
    }

    public void createCondition(int stateToBeFound, int amountToBeFound, int directionID, int conditionTypeID, int ruleID)
    {
        condition.insertCondition(stateToBeFound, amountToBeFound, directionID, conditionTypeID, ruleID);
    }

    public void deleteCondition(Condition delCondition)
    {
        condition.delete(delCondition);
    }

    public void updateCondition(Condition updateCondition)
    {
        condition.saveOrUpdate(updateCondition);
    }

    public Condition findCondition(int ID)
    {
        return condition.find(ID);
    }

    public List<Condition> findAllConditions()
    {
        List<Condition> conditionList = condition.findAllObject();
        return  conditionList;
    }
}
