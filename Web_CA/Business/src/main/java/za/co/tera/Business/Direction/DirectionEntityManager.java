package za.co.tera.Business.Direction;

import za.co.tera.Domain.impl.Direction;
import za.co.tera.data_access.impl.DirectionDAO;

import java.util.List;

/**
 * Created by Christo on 2014/07/04.
 */
public class DirectionEntityManager {

    private DirectionDAO direction = new DirectionDAO();

    public void createDirection(Direction newDirection)
    {
        direction.insertDirection(newDirection.getDirectionName());
    }

    public void createDirection(String directionName)
    {
        direction.insertDirection(directionName);
    }

    public void deleteDirection(Direction delDirection)
    {
        direction.delete(delDirection);
    }

    public void updateDirection(Direction updateDirection)
    {
        direction.saveOrUpdate(updateDirection);
    }

    public Direction findDirection(int ID)
    {
        return direction.find(ID);
    }

    public List<Direction> findAllDirections()
    {
        List<Direction> directionList = direction.findAllObject();
        return  directionList;
    }
}
