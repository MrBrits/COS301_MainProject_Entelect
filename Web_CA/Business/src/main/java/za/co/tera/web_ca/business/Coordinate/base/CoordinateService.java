package za.co.tera.web_ca.business.Coordinate.base;

import za.co.tera.web_ca.domain.impl.Coordinate;

import java.util.List;

public interface CoordinateService {
    public void createCoordinate(Coordinate newCoordinate);
    public void deleteCoordinate(Coordinate delCoordinate);
    public void updateCoordinate(Coordinate updateCoordinate);
    public Coordinate findCoordinate(int ID);
    public List<Coordinate> findAllCoordinates();
}
