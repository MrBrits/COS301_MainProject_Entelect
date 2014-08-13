package za.co.tera.web_ca.data_access;

import za.co.tera.web_ca.data_access.base.AbstractDao;
import za.co.tera.web_ca.domain.impl.Ruleresultneighbours;

public interface RuleResultneighboursDao extends AbstractDao<Ruleresultneighbours> {
    public int getRuleResNeighId(Ruleresultneighbours ruleResNeigh);

}
