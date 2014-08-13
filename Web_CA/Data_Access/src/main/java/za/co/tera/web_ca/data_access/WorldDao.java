package za.co.tera.web_ca.data_access;

import za.co.tera.web_ca.data_access.base.AbstractDao;
import za.co.tera.web_ca.domain.impl.World;

import java.util.List;

public interface WorldDao extends AbstractDao<World> {
    public List<World> findWorldByUserId(int ownerId);
}
