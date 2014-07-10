package za.co.tera.Business.Rule;

import za.co.tera.Domain.impl.Rule;
import za.co.tera.data_access.impl.RuleDAO;

import java.util.List;

/**
 * Created by Christo on 2014/07/04.
 */
public class RuleEntityManager {
    
    private RuleDAO ruleDAO = new RuleDAO();

    public void createRule(Rule newRule)
    {
        ruleDAO.insertRule(newRule.getRuleName(), newRule.getRuleDesc(), newRule.getPriority(), newRule.getCurrentValue(), newRule.getNextValue(), newRule.getWorldId(), newRule.getOwnerId());
    }

    public void createRule(String ruleName, String ruleDesc, int rulePriority, int ruleCurrentValue, int ruleNextValue, int worldID, int ownerID)
    {
        ruleDAO.insertRule(ruleName, ruleDesc, rulePriority, ruleCurrentValue, ruleNextValue, worldID, ownerID);
    }

    public void deleteRule(Rule delRule)
    {
        ruleDAO.delete(delRule);
    }

    public void updateRule(Rule updateRule)
    {
        ruleDAO.saveOrUpdate(updateRule);
    }

    public Rule findRule(int ID)
    {
        return ruleDAO.find(ID);
    }

    public List<Rule> findAllRules()
    {
        List<Rule> ruleList = ruleDAO.findAllObject();
        return  ruleList;
    }
    
}
