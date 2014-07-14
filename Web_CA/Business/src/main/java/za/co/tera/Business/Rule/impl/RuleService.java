package za.co.tera.Business.Rule.impl;

import za.co.tera.Data_Access.impl.RuleDAO;
import za.co.tera.Domain.impl.Rule;

import java.util.List;

/**
 * Created by Christo on 2014/07/14.
 */
public class RuleService {

    private RuleDAO ruleDAO = new RuleDAO();

    public void createRule(Rule newRule)
    {
        ruleDAO.insertRule(newRule);
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
