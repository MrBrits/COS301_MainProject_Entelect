package za.co.tera.web_ca.business.World.base;

import za.co.tera.web_ca.domain.impl.Coordinate;
import za.co.tera.web_ca.domain.impl.World;
import za.co.tera.web_ca.domain.impl.Worldrules;

import java.io.IOException;
import java.util.List;

public interface WorldService {
    public int createWorld(World newWorld);
    public void deleteWorld(World delWorld);
    public void updateWorld(World updateWorld);
    public World findWorld(int ID);
    public List<World> findAllWorlds();
    public List<World> findWorldByUserId(int ID);
    public List<Coordinate> findCoordinateByWorldId(int worldId);
    public void updateCoordinates(List<Coordinate> coordinateList);
    public List<World>findWorldNotByUserId(int ID);
    public void ImportWorld(int newOwner,int worldId) throws IOException;
    public void SaveWorldRules(List<Worldrules> worldrulesList);
}
