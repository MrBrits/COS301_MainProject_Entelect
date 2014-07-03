package za.co.tera.data_access.impl;

import za.co.tera.Domain.impl.Rule;
import za.co.tera.data_access.base.EntityDOA;

import java.util.List;

/**
 * Created by Laptop on 7/3/2014.
 */
public class RuleDOA implements EntityDOA<Rule>{
    @Override
    public void saveOrUpdate(Rule object) {

    }

    @Override
    public void delete(Rule object) {

    }

    @Override
    public Rule find(int id) {
        return new Rule();
    }

    @Override
    public List<Rule> findAllObject() {
        return null;
    }

    public void insertRule(String ruleName,String ruleDesc,int priority,int conditionId,int currentValue,int nextValue,int worldId,int ownerId)
    {
        Rule rule = new Rule( ruleName,ruleDesc,priority,conditionId,currentValue,nextValue,worldId,ownerId);
    }
}
