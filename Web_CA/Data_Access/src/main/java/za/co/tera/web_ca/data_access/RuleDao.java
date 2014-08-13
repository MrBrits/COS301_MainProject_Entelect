package za.co.tera.web_ca.data_access;

import za.co.tera.web_ca.data_access.base.AbstractDao;
import za.co.tera.web_ca.domain.impl.Rule;

import java.util.List;

public interface RuleDao extends AbstractDao<Rule> {
    public List<Rule> findRuleByUserId(int ownerId);
}
