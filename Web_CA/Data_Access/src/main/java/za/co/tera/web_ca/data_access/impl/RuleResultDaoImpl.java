package za.co.tera.web_ca.data_access.impl;

import za.co.tera.web_ca.data_access.RuleResultDao;
import za.co.tera.web_ca.data_access.base.impl.AbstractDaoImpl;
import za.co.tera.web_ca.domain.impl.Ruleresult;

/**
 * Created by Laptop on 7/14/2014.
 */
public class RuleResultDaoImpl extends AbstractDaoImpl<Ruleresult> implements RuleResultDao {
    public RuleResultDaoImpl()
    {
        super(Ruleresult.class);
    }
}
