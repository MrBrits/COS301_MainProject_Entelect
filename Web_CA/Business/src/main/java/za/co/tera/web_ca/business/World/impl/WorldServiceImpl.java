package za.co.tera.web_ca.business.World.impl;

import za.co.tera.web_ca.business.World.base.WorldService;
import za.co.tera.web_ca.data_access.CoordinateDao;
import za.co.tera.web_ca.data_access.WorldDao;
import za.co.tera.web_ca.data_access.impl.CoordinateDaoImpl;
import za.co.tera.web_ca.data_access.impl.WorldDaoImpl;
import za.co.tera.web_ca.domain.impl.Coordinate;
import za.co.tera.web_ca.domain.impl.World;

import java.util.List;

/**
 * Created by Laptop on 7/14/2014.
 */
public class WorldServiceImpl implements WorldService{
    private WorldDao worldDAO = new WorldDaoImpl();
    private CoordinateDao coordinateDao = new CoordinateDaoImpl();
    public void createWorld(World newWorld)
    {
        int worldId= worldDAO.save(newWorld).getWorldId();
        for (int i = 0; i < newWorld.getWorldHeight(); i++) {
            for (int j = 0; j < newWorld.getWorldWidth(); j++) {
                for (int k = 0; k < newWorld.getWorldDepth(); k++) {
                    coordinateDao.save(new Coordinate(i,j,k,0,worldId));
                }
            }
        }
    }
    public List<Coordinate> getWorldCoordinates(int worldID)
    {
        return coordinateDao.findByworldId(worldID);
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

    public List<World> findAllWorlds()  {
        List<World> worldList = worldDAO.findAll();
        return  worldList;
    }

    @Override
    public List<World> findWorldByUserId(int ID) {
        List<World> worldList = worldDAO.findWorldByUserId(ID);
        return  worldList;
    }

    @Override
    public List<Coordinate> findCoordinateByWorldId(int worldId) {
       return coordinateDao.findByworldId(worldId);
    }
}
