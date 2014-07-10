package za.co.tera.Business.Direction;

import za.co.tera.Domain.impl.Direction;
import za.co.tera.data_access.impl.DirectionDAO;

import java.util.List;

/**
 * Created by Christo on 2014/07/04.
 */
public class DirectionEntityManager {

    private DirectionDAO directionDAO = new DirectionDAO();

    public void createDirection(Direction newDirection)
    {
        directionDAO.insertDirection(newDirection.getDirectionDesc());
    }

    public void createDirection(String directionName)
    {
        directionDAO.insertDirection(directionName);
    }

    public void deleteDirection(Direction delDirection)
    {
        directionDAO.delete(delDirection);
    }

    public void updateDirection(Direction updateDirection)
    {
        directionDAO.saveOrUpdate(updateDirection);
    }

    public Direction findDirection(int ID)
    {
        return directionDAO.find(ID);
    }

    public List<Direction> findAllDirections()
    {
        List<Direction> directionList = directionDAO.findAllObject();
        return  directionList;
    }
}
