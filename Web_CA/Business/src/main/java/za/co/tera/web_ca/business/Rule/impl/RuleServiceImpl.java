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
    private WorldRulesDao worldRulesDao = new WorldRulesDaoImpl();

    @Override
    public boolean createRule(Rule newRule)
    {
        int ID = newRule.getOwnerId();
        ID = (ID + 321)/369;
        newRule.setOwnerId(ID);

        ruleDao.save(newRule);
        return true;
    }

    @Override
    public List<Rulecondition> findAllConditions() {
        return ruleConditionDao.findAll();
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
    public List<Worldrules> findRuleByWorldId(int worldID) {
        return worldRulesDao.findRuleByWorldId(worldID);
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
        int userId = updateRule.getOwnerId();
        userId = (userId + 321)/369;
        updateRule.setOwnerId(userId);
        ruleDao.save(updateRule);
    }
    @Override
    public Rule findRule(int ruleId)
    {
        return ruleDao.findById(ruleId);
    }
    @Override
    public List<Rule> findAllRules()    {
        List<Rule> ruleList = ruleDao.findAll();
        return  ruleList;
    }
    @Override
    public List<Rule> findRuleByUserId(int userId) {
        userId = (userId + 321)/369;
        List<Rule> ruleList = ruleDao.findRuleByUserId(userId);
        return  ruleList;
    }
    @Override
     public Rulecondition findRuleCon(int conId)
    {
        return ruleConditionDao.findById(conId);
    }

    @Override
    public Ruleresult findRuleRes(int resId)
    {
        return ruleResultDao.findById(resId);
    }

    @Override
    public Ruleneighbours findRuleNeigh(int neighId)
    {
        return ruleNeighboursDao.findById(neighId);
    }

}
