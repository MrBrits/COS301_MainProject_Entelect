package za.co.tera.web_ca.business.Rule.base;

import za.co.tera.web_ca.domain.impl.*;

import java.util.List;


public interface RuleService {
    public boolean createRule(Rule newRule);
    public int createRuleCon(Rulecondition newRuleCon);
    public int createRuleNeigh(Ruleneighbours newRuleConNeigh);
    public int createRuleRes(Ruleresult newRuleRes);
    public void deleteRule(Rule delRule);
    public void updateRule(Rule updateRule);
    public Rule findRule(int ruleId);
    public Rulecondition findRuleCon(int ruleConId);
    public Ruleresult findRuleRes(int ruleResId);
    public Ruleneighbours findRuleNeigh(int ruleNeighId);
    public List<Rule> findAllRules();
    public List<Rule> findRuleByUserId(int userId);
}
