package za.co.tera.web_ca.business.Coordinate.base;

import za.co.tera.web_ca.domain.impl.Coordinate;

import java.util.List;

/**
 * Created by Christo on 2014/07/14.
 */
public interface CoordinateService {

    public void createCoordinate(Coordinate newCoordinate);
    public void deleteCoordinate(Coordinate delCoordinate);
    public void updateCoordinate(Coordinate updateCoordinate);
    public Coordinate findCoordinate(int ID);
    public List<Coordinate> findAllCoordinates();

}
