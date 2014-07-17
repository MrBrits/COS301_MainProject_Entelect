package za.co.tera.web_ca.data_access.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import za.co.tera.web_ca.data_access.StateDao;
import za.co.tera.web_ca.data_access.base.impl.AbstractDaoImpl;
import za.co.tera.web_ca.domain.impl.State;

import java.util.List;

/**
 * Created by Laptop on 7/14/2014.
 */
public class StateDaoImpl extends AbstractDaoImpl<State> implements StateDao {
    public StateDaoImpl()
    {
        super(State.class);
    }

    @Override
    public List<State> findStateByUserId(int ownerId) {

        Session session= getSession();
        Query query = session.createQuery("From State state where state.ownerId = :ownerId");
        query.setParameter("ownerId", ownerId);
        List<State> stateList = query.list();
        return stateList;
    }
}
