package za.co.tera.Business.Coordinate.impl;

import za.co.tera.Data_Access.impl.CoordinateDAO;
import za.co.tera.Domain.impl.Coordinate;

import java.util.List;

/**
 * Created by Christo on 2014/07/14.
 */
public class CoordinateService {

    private CoordinateDAO coordinateDAO = new CoordinateDAO();

    public void createCoordinate(Coordinate newCoordinate)
    {
        coordinateDAO.insertCoordinate(newCoordinate);
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
