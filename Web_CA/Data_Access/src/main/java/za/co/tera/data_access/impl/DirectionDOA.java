package za.co.tera.data_access.impl;

import za.co.tera.Domain.impl.Direction;
import za.co.tera.data_access.base.EntityDOA;

import java.util.List;

/**
 * Created by Laptop on 7/3/2014.
 */
public class DirectionDOA implements EntityDOA<Direction> {
    @Override
    public void saveOrUpdate(Direction object) {

    }

    @Override
    public void delete(Direction object) {

    }

    @Override
    public Direction find(int id) {
        return new Direction();
    }

    @Override
    public List<Direction> findAllObject() {
        return null;
    }

    public void insertDirection(String directionName)
    {
        Direction direction = new Direction( directionName);
    }
}
