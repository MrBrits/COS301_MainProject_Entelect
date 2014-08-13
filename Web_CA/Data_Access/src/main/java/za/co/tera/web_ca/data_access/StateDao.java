package za.co.tera.web_ca.data_access;

import za.co.tera.web_ca.data_access.base.AbstractDao;
import za.co.tera.web_ca.domain.impl.State;

import java.util.List;

public interface StateDao extends AbstractDao<State> {
    public List<State> findStateByUserId(int ownerId);
}
