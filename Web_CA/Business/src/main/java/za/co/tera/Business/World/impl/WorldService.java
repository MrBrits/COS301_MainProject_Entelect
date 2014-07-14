package za.co.tera.Business.World.impl;

import za.co.tera.Data_Access.impl.WorldDAO;
import za.co.tera.Domain.impl.World;

import java.util.List;

/**
 * Created by Christo on 2014/07/14.
 */
public class WorldService {
    private WorldDAO worldDAO = new WorldDAO();

    public void createWorld(World newWorld)
    {
        worldDAO.insertWorld(newWorld);
    }

    public void deleteWorld(World delWorld)
    {
        worldDAO.delete(delWorld);
    }

    public void updateWorld(World updateWorld)
    {
        worldDAO.saveOrUpdate(updateWorld);
    }

    public World findWorld(int ID)
    {
        return worldDAO.find(ID);
    }

    public List<World> findAllWorlds()
    {
        List<World> worldList = worldDAO.findAllObject();
        return  worldList;
    }
}
