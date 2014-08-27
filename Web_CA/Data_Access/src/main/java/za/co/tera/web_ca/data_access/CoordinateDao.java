package za.co.tera.web_ca.data_access;

import za.co.tera.web_ca.data_access.base.AbstractDao;
import za.co.tera.web_ca.domain.impl.Coordinate;
import za.co.tera.web_ca.domain.impl.World;

import java.util.List;

public interface CoordinateDao extends AbstractDao<Coordinate>
{
    public List<Coordinate> findByworldId(int worldId);
    public void saveCoordinates(World newWorld);

}
