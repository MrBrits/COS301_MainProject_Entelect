package za.co.tera.web_ca.business.Rule.base;

import za.co.tera.web_ca.domain.impl.Rule;

import java.util.List;

/**
 * Created by Christo on 2014/07/14.
 */
public interface RuleService {

    public void createRule(Rule newRule);
    public void deleteRule(Rule delRule);
    public void updateRule(Rule updateRule);
    public Rule findRule(int ID);
    public List<Rule> findAllRules();

}
