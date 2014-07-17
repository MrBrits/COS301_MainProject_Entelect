package za.co.tera.web_ca.business.World.base;

import za.co.tera.web_ca.domain.impl.World;

import java.util.List;

/**
 * Created by Christo on 2014/07/14.
 */
public interface WorldService {


    public void createWorld(World newWorld);
    public void deleteWorld(World delWorld);
    public void updateWorld(World updateWorld);
    public World findWorld(int ID);
    public List<World> findAllWorlds();
    public List<World> findWorldByUserId(int ID);
}
