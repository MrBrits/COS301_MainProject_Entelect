package za.co.tera.web_ca.business.World.impl;

import za.co.tera.web_ca.business.World.base.WorldService;
import za.co.tera.web_ca.data_access.WorldDao;
import za.co.tera.web_ca.data_access.impl.WorldDaoImpl;
import za.co.tera.web_ca.domain.impl.World;

import java.util.List;

/**
 * Created by Laptop on 7/14/2014.
 */
public class WorldServiceImpl implements WorldService{
    private WorldDao worldDAO = new WorldDaoImpl();

    public void createWorld(World newWorld)
    {
        worldDAO.save(newWorld);
    }

    public void deleteWorld(World delWorld)
    {
        worldDAO.delete(delWorld);
    }

    public void updateWorld(World updateWorld)
    {
        worldDAO.save(updateWorld);
    }

    public World findWorld(int ID)
    {
        return worldDAO.findById(ID);
    }

    public List<World> findAllWorlds()
    {
        List<World> worldList = worldDAO.findAll();
        return  worldList;
    }

    @Override
    public List<World> findWorldByUserId(int ID) {
        List<World> worldList = worldDAO.findWorldByUserId(ID);
        return  worldList;
    }
}
