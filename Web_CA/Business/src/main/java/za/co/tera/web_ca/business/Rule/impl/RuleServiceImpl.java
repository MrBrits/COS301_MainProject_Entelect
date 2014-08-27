package za.co.tera.web_ca.business.Rule.impl;

import za.co.tera.web_ca.business.Rule.base.RuleService;
import za.co.tera.web_ca.data_access.*;
import za.co.tera.web_ca.data_access.impl.*;
import za.co.tera.web_ca.domain.impl.*;

import java.util.List;

public class RuleServiceImpl implements RuleService {

    private RuleDao ruleDao = new RuleDaoImpl();

    private RuleConditionDao ruleConditionDao = new RuleConditionDaoImpl();
    private RuleResultDao ruleResultDao = new RuleResultDaoImpl();
    private RuleNeighboursDao ruleNeighboursDao = new RuleNeighboursDaoImpl();

    @Override
    public boolean createRule(Rule newRule)
    {
        ruleDao.save(newRule);
        return true;
    }

    @Override
    public int createRuleCon(Rulecondition newRuleCon)
    {
        int Id = ruleConditionDao.getRuleConditionId(newRuleCon);

        if (Id == 0) {
            ruleConditionDao.save(newRuleCon);
            Id = ruleConditionDao.getRuleConditionId(newRuleCon);
        }
        return Id;
    }

    @Override
    public int createRuleNeigh(Ruleneighbours ruleneighbours)
    {
        int Id = ruleNeighboursDao.getRuleNeighboursId(ruleneighbours);

        if (Id == 0) {
            ruleNeighboursDao.save(ruleneighbours);
            Id = ruleNeighboursDao.getRuleNeighboursId(ruleneighbours);
        }
        return Id;
    }

    @Override
    public int createRuleRes(Ruleresult newRuleRes)
    {

        int Id = ruleResultDao.getRuleResultId(newRuleRes);

        if (Id == 0) {
            ruleResultDao.save(newRuleRes);
            Id = ruleResultDao.getRuleResultId(newRuleRes);
        }
        return Id;
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
