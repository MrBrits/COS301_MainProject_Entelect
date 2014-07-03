package za.co.tera.data_access.impl;

import za.co.tera.Domain.impl.Coordinate;
import za.co.tera.data_access.base.EntityDOA;

import java.util.List;

/**
 * Created by Laptop on 7/3/2014.
 */
public class CoordinateDOA implements EntityDOA<Coordinate> {
    @Override
    public void saveOrUpdate(Coordinate object) {

    }

    @Override
    public void delete(Coordinate object) {

    }

    @Override
    public Coordinate find(int id) {
        return new Coordinate();
    }

    @Override
    public List<Coordinate> findAllObject() {
        return null;
    }

    public void insertCoordinate(int coordinateX,int coordinateY, int coordinateZ,int stateId,int worldId)
    {
        Coordinate coordinate = new Coordinate(coordinateX,coordinateY,coordinateZ,stateId,worldId);
    }
}
