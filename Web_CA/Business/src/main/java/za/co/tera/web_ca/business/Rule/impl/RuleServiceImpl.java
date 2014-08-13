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
    public int createRuleConNeigh(Ruleconditionneighbours newRuleConNeigh)
    {
        int Id = ruleConditionNeighboursDao.getRuleConNeighId(newRuleConNeigh);

        if (Id == 0) {
            ruleConditionNeighboursDao.save(newRuleConNeigh);
            Id = ruleConditionNeighboursDao.getRuleConNeighId(newRuleConNeigh);
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
    public int createRuleResNeigh(Ruleresultneighbours newRuleResNeigh)
    {
        int Id = ruleResultNeighboursDao.getRuleResNeighId(newRuleResNeigh);

        if (Id == 0) {
            ruleResultNeighboursDao.save(newRuleResNeigh);
            Id = ruleResultNeighboursDao.getRuleResNeighId(newRuleResNeigh);
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
