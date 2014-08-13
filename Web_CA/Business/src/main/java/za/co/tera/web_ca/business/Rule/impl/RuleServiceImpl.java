package za.co.tera.web_ca.business.Rule.impl;

import za.co.tera.web_ca.business.Rule.base.RuleService;
import za.co.tera.web_ca.data_access.*;
import za.co.tera.web_ca.data_access.impl.*;
import za.co.tera.web_ca.domain.impl.*;

import java.util.List;

/**
 * Created by Laptop on 7/14/2014.
 */
public class RuleServiceImpl implements RuleService {

    private RuleDao ruleDao = new RuleDaoImpl();

    private RuleConditionDao ruleConditionDao = new RuleConditionDaoImpl();
    private RuleConditionNeighboursDao ruleConditionNeighboursDao = new RuleConditionNeighboursDaoImpl();

    private RuleResultDao ruleResultDao = new RuleResultDaoImpl();
    private RuleResultneighboursDao ruleResultNeighboursDao = new RuleResultNeighboursDaoImpl();

    @Override
    public boolean createRule(Rule newRule)
    {
        System.out.println("SERVICE: ADD RULE");
        ruleDao.save(newRule);
        return true;
    }

    @Override
    public int createRuleCon(Rulecondition newRuleCon)
    {
        ruleConditionDao.save(newRuleCon);
        return ruleConditionDao.getRuleConditionId(newRuleCon);
    }

    @Override
    public void createRuleConNeigh(Ruleconditionneighbours newRuleConNeigh)
    {
        ruleConditionNeighboursDao.save(newRuleConNeigh);
    }

    @Override
    public int createRuleRes(Ruleresult newRuleRes)
    {
        System.out.println("SERVICE: ADD RULERES");
        ruleResultDao.save(newRuleRes);
        return ruleResultDao.getRuleResultId(newRuleRes);
    }
    @Override
    public void createRuleResNeigh(Ruleresultneighbours newRuleResNeigh)
    {
        System.out.println("SERVICE: ADD RULERESNEIGH");
        ruleResultNeighboursDao.save(newRuleResNeigh);
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
    public List<Rule> findAllRules()    {
        List<Rule> ruleList = ruleDao.findAll();
        return  ruleList;
    }
    @Override
    public List<Rule> findRuleByUserId(int ID) {
        List<Rule> ruleList = ruleDao.findRuleByUserId(ID);
        return  ruleList;
    }
}
