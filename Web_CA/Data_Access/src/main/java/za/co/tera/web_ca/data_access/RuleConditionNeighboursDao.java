package za.co.tera.web_ca.data_access;

import za.co.tera.web_ca.data_access.base.AbstractDao;
import za.co.tera.web_ca.domain.impl.Ruleconditionneighbours;

public interface RuleConditionNeighboursDao extends AbstractDao<Ruleconditionneighbours> {
    public int getRuleConNeighId(Ruleconditionneighbours ruleConNeigh);
}
