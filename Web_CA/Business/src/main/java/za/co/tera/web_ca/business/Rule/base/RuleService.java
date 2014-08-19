package za.co.tera.web_ca.business.Rule.base;

import za.co.tera.web_ca.domain.impl.*;

import java.util.List;

/**
 * Created by Christo on 2014/07/14.
 */
public interface RuleService {
    /**
     *
     * @param newRule
     * @return
     */
    public boolean createRule(Rule newRule);

    /**
     *
     * @param newRuleCon
     * @return
     */
    public int createRuleCon(Rulecondition newRuleCon);

    /**
     *
     * @param newRuleConNeigh
     * @return
     */
    public int createRuleConNeigh(Ruleconditionneighbours newRuleConNeigh);

    /**
     *
     * @param newRuleRes
     * @return
     */
    public int createRuleRes(Ruleresult newRuleRes);

    /**
     *
     * @param newRuleResNeigh
     * @return
     */
    public int createRuleResNeigh(Ruleresultneighbours newRuleResNeigh);

    /**
     *
     * @param delRule
     */
    public void deleteRule(Rule delRule);

    /**
     *
     * @param updateRule
     */
    public void updateRule(Rule updateRule);

    /**
     *
     * @param ID
     * @return
     */
    public Rule findRule(int ID);

    /**
     *
     * @return
     */
    public List<Rule> findAllRules();

    /**
     *
     * @param ID
     * @return
     */
    public List<Rule> findRuleByUserId(int ID);
}
