package za.co.tera.web_ca.data_access.impl;

import za.co.tera.web_ca.data_access.WorldRulesDao;
import za.co.tera.web_ca.data_access.base.impl.AbstractDaoImpl;
import za.co.tera.web_ca.domain.impl.Worldrules;

public class WorldRulesDaoImpl extends AbstractDaoImpl<Worldrules> implements WorldRulesDao {
    public WorldRulesDaoImpl()
    {
        super(Worldrules.class);
    }
}
