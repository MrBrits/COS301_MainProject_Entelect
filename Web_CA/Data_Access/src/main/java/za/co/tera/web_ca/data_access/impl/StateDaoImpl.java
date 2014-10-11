package za.co.tera.web_ca.data_access.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import za.co.tera.web_ca.data_access.StateDao;
import za.co.tera.web_ca.data_access.base.impl.AbstractDaoImpl;
import za.co.tera.web_ca.domain.impl.State;

import java.util.List;

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

    @Override
    public boolean checkStateValue(int ownerId, double stateValue) {

        Session session= getSession();
        Query query = session.createQuery("From State state where state.ownerId = :ownerId and state.stateValue = :stateValue");
        query.setParameter("ownerId", ownerId);
        query.setParameter("stateValue", stateValue);
        List<State> stateList = query.list();

        if (!stateList.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }
}
