package za.co.tera.web_ca.data_access;

import za.co.tera.web_ca.data_access.base.AbstractDao;

/**
 * Created by Laptop on 7/14/2014.
 */
public interface RuleResultDao extends AbstractDao<Ruleresult> {
    public int getRuleResultId(Ruleresult ruleRes);
}
