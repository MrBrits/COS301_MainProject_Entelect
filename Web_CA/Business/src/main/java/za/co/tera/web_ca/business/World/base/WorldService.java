package za.co.tera.web_ca.business.World.base;

import za.co.tera.web_ca.domain.impl.World;

import java.util.List;

/**
 * Created by Christo on 2014/07/14.
 */
public interface WorldService {
    /**
     *
     * @param newWorld
     */
    public void createWorld(World newWorld);

    /**
     *
     * @param delWorld
     */
    public void deleteWorld(World delWorld);

    /**
     *
     * @param updateWorld
     */
    public void updateWorld(World updateWorld);

    /**
     *
     * @param ID
     * @return
     */
    public World findWorld(int ID);

    /**
     *
     * @return
     */
    public List<World> findAllWorlds();

    /**
     *
     * @param ID
     * @return
     */
    public List<World> findWorldByUserId(int ID);
}
