package za.co.tera.web_ca.data_access.impl;

import za.co.tera.web_ca.data_access.WorldDao;
import za.co.tera.web_ca.data_access.base.impl.AbstractDaoImpl;
import za.co.tera.web_ca.domain.impl.World;

/**
 * Created by Laptop on 7/14/2014.
 */
public class WorldDaoImpl extends AbstractDaoImpl<World> implements WorldDao {
    public WorldDaoImpl()
    {
        super(World.class);
    }
}
