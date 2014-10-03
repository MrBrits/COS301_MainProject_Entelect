package za.co.tera.web_ca.data_access;

import za.co.tera.web_ca.data_access.base.AbstractDao;
import za.co.tera.web_ca.domain.impl.Worldrules;

import java.util.List;

public interface WorldRulesDao extends AbstractDao<Worldrules> {

    public List<Worldrules> findRuleByWorldId(int worldID);
}
