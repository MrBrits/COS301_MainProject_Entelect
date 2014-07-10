package za.co.tera.Business.World;

import za.co.tera.Domain.impl.World;
import za.co.tera.data_access.impl.WorldDAO;

import java.util.List;

/**
 * Created by Christo on 2014/07/09.
 */
public class WorldEntityManager {

    private WorldDAO world = new WorldDAO();

    public void createWorld(World newWorld)
    {
        world.insertWorld(newWorld.getWorldName(), newWorld.getWorldDesc(), newWorld.getWorldDimension(), newWorld.getWorldWidth(), newWorld.getWorldHeight(), newWorld.getWorldDepth(), newWorld.getOwnerId());
    }

    public void createWorld(String worldName, String worldDesc, int worldDimension, int worldWidth, int worldHeight, int worldDepth, int ownerID)
    {
        world.insertWorld(worldName, worldDesc, worldDimension, worldWidth, worldHeight, worldDepth, ownerID);
    }

    public void deleteWorld(World delWorld)
    {
        world.delete(delWorld);
    }

    public void updateWorld(World updateWorld)
    {
        world.saveOrUpdate(updateWorld);
    }

    public World findWorld(int ID)
    {
        return world.find(ID);
    }

    public List<World> findAllWorlds()
    {
        List<World> worldList = world.findAllObject();
        return  worldList;
    }
}
