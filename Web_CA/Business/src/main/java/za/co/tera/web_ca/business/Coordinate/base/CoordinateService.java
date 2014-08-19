package za.co.tera.web_ca.business.Coordinate.base;

import za.co.tera.web_ca.domain.impl.Coordinate;

import java.util.List;

/**
 * Created by Christo on 2014/07/14.
 */
public interface CoordinateService {
    /**
     *
     * @param newCoordinate
     */
    public void createCoordinate(Coordinate newCoordinate);

    /**
     *
     * @param delCoordinate
     */
    public void deleteCoordinate(Coordinate delCoordinate);

    /**
     *
     * @param updateCoordinate
     */
    public void updateCoordinate(Coordinate updateCoordinate);

    /**
     *
     * @param ID
     * @return
     */
    public Coordinate findCoordinate(int ID);

    /**
     *
     * @return
     */
    public List<Coordinate> findAllCoordinates();
}
