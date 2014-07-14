package za.co.tera.web_ca.data_access.impl;

import za.co.tera.web_ca.data_access.StateDao;
import za.co.tera.web_ca.data_access.base.impl.AbstractDaoImpl;
import za.co.tera.web_ca.domain.impl.State;

/**
 * Created by Laptop on 7/14/2014.
 */
public class StateDaoImpl extends AbstractDaoImpl<State> implements StateDao {
    public StateDaoImpl()
    {
        super(State.class);
    }
}
