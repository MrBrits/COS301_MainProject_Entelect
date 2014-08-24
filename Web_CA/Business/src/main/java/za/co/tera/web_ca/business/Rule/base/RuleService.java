package za.co.tera.web_ca.business.Rule.base;

import za.co.tera.web_ca.domain.impl.*;

import java.util.List;


public interface RuleService {
    public boolean createRule(Rule newRule);
    public int createRuleCon(Rulecondition newRuleCon);
    public int createRuleConNeigh(Ruleconditionneighbours newRuleConNeigh);
    public int createRuleRes(Ruleresult newRuleRes);
    public int createRuleResNeigh(Ruleresultneighbours newRuleResNeigh);
    public void deleteRule(Rule delRule);
    public void updateRule(Rule updateRule);
    public Rule findRule(int ID);
    public List<Rule> findAllRules();
    public List<Rule> findRuleByUserId(int ID);
}
