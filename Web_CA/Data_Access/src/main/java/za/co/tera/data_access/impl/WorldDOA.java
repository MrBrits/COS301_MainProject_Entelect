package za.co.tera.data_access.impl;

import za.co.tera.Domain.impl.World;
import za.co.tera.data_access.base.EntityDOA;

import java.util.List;

/**
 * Created by Laptop on 7/3/2014.
 */
public class WorldDOA implements EntityDOA<World>{

    @Override
    public void saveOrUpdate(World object) {

    }

    @Override
    public void delete(World object) {

    }

    @Override
    public World find(int id) {
        return new World();
    }

    @Override
    public List<World> findAllObject() {
        return null;
    }
    public void insertWorld(String worldName,String worldDesc,int worldDimension,int worldWidth,int worldHeight,int worldLength,int ownerId)
    {
        World world = new World(worldName,worldDesc,worldDimension,worldWidth,worldHeight,worldLength,ownerId);
    }
}
