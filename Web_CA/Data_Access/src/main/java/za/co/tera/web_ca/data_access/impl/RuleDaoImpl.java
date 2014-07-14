package za.co.tera.web_ca.data_access.impl;

import za.co.tera.web_ca.data_access.RuleDao;
import za.co.tera.web_ca.data_access.base.impl.AbstractDaoImpl;
import za.co.tera.web_ca.domain.impl.Rule;

/**
 * Created by Laptop on 7/14/2014.
 */
public class RuleDaoImpl extends AbstractDaoImpl<Rule> implements RuleDao {
    public RuleDaoImpl()
    {
        super(Rule.class);
    }
}
