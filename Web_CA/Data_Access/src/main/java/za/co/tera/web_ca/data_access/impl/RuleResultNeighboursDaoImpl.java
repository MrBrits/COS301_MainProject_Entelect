package za.co.tera.web_ca.data_access.impl;

import za.co.tera.web_ca.data_access.RuleResultNeighboursDao;
import za.co.tera.web_ca.data_access.base.impl.AbstractDaoImpl;
import za.co.tera.web_ca.domain.impl.Ruleresultneighbours;

/**
 * Created by Laptop on 7/14/2014.
 */
public class RuleResultNeighboursDaoImpl extends AbstractDaoImpl<Ruleresultneighbours> implements RuleResultNeighboursDao {
    public RuleResultNeighboursDaoImpl()
    {
        super(Ruleresultneighbours.class);
    }
}
