package za.co.tera.web_ca.business.Rule.base;

import za.co.tera.web_ca.domain.impl.*;

import java.util.List;

/**
 * Created by Christo on 2014/07/14.
 */
public interface RuleService {

    public boolean createRule(Rule newRule);

    public int createRuleCon(Rulecondition newRuleCon);
    public void createRuleConNeigh(Ruleconditionneighbours newRuleConNeigh);

    public int createRuleRes(Ruleresult newRuleRes);
    public void createRuleResNeigh(Ruleresultneighbours newRuleResNeigh);

    public void deleteRule(Rule delRule);
    public void updateRule(Rule updateRule);
    public Rule findRule(int ID);
    public List<Rule> findAllRules();
    public List<Rule> findRuleByUserId(int ID);
}
