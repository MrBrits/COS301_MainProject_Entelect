package za.co.tera.web_ca.data_access;

import za.co.tera.web_ca.data_access.base.AbstractDao;
import za.co.tera.web_ca.domain.impl.Ruleresult;

public interface RuleResultDao extends AbstractDao<Ruleresult> {
    public int getRuleResultId(Ruleresult ruleRes);
}
