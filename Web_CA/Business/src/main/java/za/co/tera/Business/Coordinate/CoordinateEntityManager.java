package za.co.tera.Business.Coordinate;

import za.co.tera.Domain.impl.Coordinate;
import za.co.tera.data_access.impl.CoordinateDAO;

import java.util.List;

/**
 * Created by Christo on 2014/07/04.
 */
public class CoordinateEntityManager {

    private CoordinateDAO coordinateDAO = new CoordinateDAO();

    public void createCoordinate(Coordinate newCoordinate)
    {
        coordinateDAO.insertCoordinate(newCoordinate.getCoordinateX(), newCoordinate.getCoordinateY(), newCoordinate.getCoordinateZ(), newCoordinate.getStateId(), newCoordinate.getWorldId());
    }

    public void createCoordinate(String coordinateName, int coordinateX, int coordinateY, int coordinateZ, int stateID, int worldID)
    {
        coordinateDAO.insertCoordinate(coordinateX, coordinateY, coordinateZ, stateID, worldID);
    }

    public void deleteCoordinate(Coordinate delCoordinate)
    {
        coordinateDAO.delete(delCoordinate);
    }

    public void updateCoordinate(Coordinate updateCoordinate)
    {
        coordinateDAO.saveOrUpdate(updateCoordinate);
    }

    public Coordinate findCoordinate(int ID)
    {
        return coordinateDAO.find(ID);
    }

    public List<Coordinate> findAllCoordinates()
    {
        List<Coordinate> coordinateList = coordinateDAO.findAllObject();
        return  coordinateList;
    }
}
