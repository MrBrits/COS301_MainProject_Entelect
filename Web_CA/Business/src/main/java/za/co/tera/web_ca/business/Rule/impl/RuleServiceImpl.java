package za.co.tera.web_ca.business.Rule.impl;

import za.co.tera.web_ca.business.Rule.base.RuleService;
import za.co.tera.web_ca.data_access.RuleDao;
import za.co.tera.web_ca.data_access.impl.RuleDaoImpl;
import za.co.tera.web_ca.domain.impl.Rule;

import java.util.List;

/**
 * Created by Laptop on 7/14/2014.
 */
public class RuleServiceImpl implements RuleService {

    private RuleDao ruleDao = new RuleDaoImpl();
    @Override
    public void createRule(Rule newRule)
    {
        ruleDao.save(newRule);
    }
    @Override
    public void deleteRule(Rule delRule)
    {
        ruleDao.delete(delRule);
    }
    @Override
    public void updateRule(Rule updateRule)
    {
        ruleDao.save(updateRule);
    }
    @Override
    public Rule findRule(int ID)
    {
        return ruleDao.findById(ID);
    }
    @Override
    public List<Rule> findAllRules()
    {
        List<Rule> ruleList = ruleDao.findAll();
        return  ruleList;
    }
}
