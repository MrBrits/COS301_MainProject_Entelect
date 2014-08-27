package za.co.tera.web_ca.data_access;

import za.co.tera.web_ca.data_access.base.AbstractDao;
import za.co.tera.web_ca.domain.impl.Ruleneighbours;

public interface RuleNeighboursDao extends AbstractDao<Ruleneighbours> {
    public int getRuleNeighboursId(Ruleneighbours ruleneighbours);
}


