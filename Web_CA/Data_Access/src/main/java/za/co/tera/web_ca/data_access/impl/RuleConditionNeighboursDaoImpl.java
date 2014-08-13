package za.co.tera.web_ca.data_access.impl;

import za.co.tera.web_ca.data_access.RuleConditionNeighboursDao;
import za.co.tera.web_ca.data_access.base.impl.AbstractDaoImpl;
import za.co.tera.web_ca.domain.impl.Ruleconditionneighbours;

/**
 * Created by Laptop on 7/14/2014.
 */
public class RuleConditionNeighboursDaoImpl extends AbstractDaoImpl<Ruleconditionneighbours> implements RuleConditionNeighboursDao {
    public RuleConditionNeighboursDaoImpl()
    {
        super(Ruleconditionneighbours.class);
    }
}
