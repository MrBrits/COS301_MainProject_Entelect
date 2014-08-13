package za.co.tera.web_ca.data_access.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import za.co.tera.web_ca.data_access.WorldDao;
import za.co.tera.web_ca.data_access.base.impl.AbstractDaoImpl;
import za.co.tera.web_ca.domain.impl.World;

import java.util.List;

public class WorldDaoImpl extends AbstractDaoImpl<World> implements WorldDao {
    public WorldDaoImpl()
    {
        super(World.class);
    }

    @Override
    public List<World> findWorldByUserId(int ownerId) {
        Session session= getSession();
        Query query = session.createQuery("From World world where world.ownerId = :ownerId");
        query.setParameter("ownerId", ownerId);
        List<World> worldList = query.list();
        return worldList;
    }
}
