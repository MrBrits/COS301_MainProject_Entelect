package za.co.tera.web_ca.data_access.impl;

import za.co.tera.web_ca.data_access.RuleConditionDao;
import za.co.tera.web_ca.data_access.base.impl.AbstractDaoImpl;
import za.co.tera.web_ca.domain.impl.Rulecondition;

/**
 * Created by Laptop on 7/14/2014.
 */
public class RuleConditionDaoImpl extends AbstractDaoImpl<Rulecondition> implements RuleConditionDao{
    public RuleConditionDaoImpl()
    {
        super(Rulecondition.class);
    }
}
