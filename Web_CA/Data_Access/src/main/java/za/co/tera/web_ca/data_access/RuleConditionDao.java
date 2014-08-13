package za.co.tera.web_ca.data_access;

import za.co.tera.web_ca.data_access.base.AbstractDao;
import za.co.tera.web_ca.domain.impl.Rulecondition;

public interface RuleConditionDao extends AbstractDao<Rulecondition> {
    public int getRuleConditionId(Rulecondition ruleCon);
}
