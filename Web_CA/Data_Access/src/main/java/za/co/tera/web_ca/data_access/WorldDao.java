package za.co.tera.web_ca.data_access;

import za.co.tera.web_ca.data_access.base.AbstractDao;
import za.co.tera.web_ca.domain.impl.World;

import java.util.List;

/**
 * Created by Laptop on 7/14/2014.
 */
public interface WorldDao extends AbstractDao<World> {
    public List<World> findWorldByUserId(int ownerId);
}
