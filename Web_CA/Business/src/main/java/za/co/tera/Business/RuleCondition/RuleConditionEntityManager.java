package za.co.tera.Business.RuleCondition;

import za.co.tera.Domain.impl.Rulecondition;
import za.co.tera.data_access.impl.RuleConditionDAO;

import java.util.List;

/**
 * Created by Christo on 2014/07/10.
 */
public class RuleConditionEntityManager {

    private RuleConditionDAO ruleConditionDAO = new RuleConditionDAO();

    public void createRuleCondition(Rulecondition newRuleCondition)
    {
        ruleConditionDAO.insertRulecondition(newRuleCondition.getAmountToFind(), newRuleCondition.getStateToFind(), newRuleCondition.getConditionTypeId(), newRuleCondition.getDirectionId(), newRuleCondition.getRuleId());
    }

    public void createRuleCondition(int amountToFind, int stateToFind, int conditionTypeId, int directionId, int ruleId)
    {
        ruleConditionDAO.insertRulecondition(amountToFind, stateToFind, conditionTypeId, directionId, ruleId);
    }

    public void deleteRuleCondition(Rulecondition delRuleCondition)
    {
        ruleConditionDAO.delete(delRuleCondition);
    }

    public void updateRuleCondition(Rulecondition updateRuleCondition)
    {
        ruleConditionDAO.saveOrUpdate(updateRuleCondition);
    }

    public Rulecondition findRuleCondition(int ID)
    {
        return ruleConditionDAO.find(ID);
    }

    public List<Rulecondition> findAllRuleConditions()
    {
        List<Rulecondition> ruleConditionList = ruleConditionDAO.findAllObject();
        return  ruleConditionList;
    }
}
