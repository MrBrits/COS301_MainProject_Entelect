package za.co.tera.web_ca.business.Coordinate.impl;

import za.co.tera.web_ca.business.Coordinate.base.CoordinateService;
import za.co.tera.web_ca.data_access.CoordinateDao;
import za.co.tera.web_ca.data_access.impl.CoordinateDaoImpl;
import za.co.tera.web_ca.domain.impl.Coordinate;

import java.util.List;

/**
 * Created by Laptop on 7/14/2014.
 */
public class CoordinateServiceImpl implements CoordinateService{

    CoordinateDao coordinateDao = new CoordinateDaoImpl();
    @Override
    public void createCoordinate(Coordinate newCoordinate)
    {
        coordinateDao.save(newCoordinate);
    }
    @Override
    public void deleteCoordinate(Coordinate delCoordinate)
    {
        coordinateDao.delete(delCoordinate);
    }
    @Override
    public void updateCoordinate(Coordinate updateCoordinate)
    {
        coordinateDao.save(updateCoordinate);
    }
    @Override
    public Coordinate findCoordinate(int ID)
    {
        return coordinateDao.findById(ID);
    }
    @Override
    public List<Coordinate> findAllCoordinates()
    {
        List<Coordinate> coordinateList = coordinateDao.findAll();
        return coordinateList;
    }
}
