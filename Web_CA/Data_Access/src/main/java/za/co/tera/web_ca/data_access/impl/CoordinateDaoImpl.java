package za.co.tera.web_ca.data_access.impl;

import za.co.tera.web_ca.data_access.CoordinateDao;
import za.co.tera.web_ca.data_access.base.impl.AbstractDaoImpl;
import za.co.tera.web_ca.domain.impl.Coordinate;

/**
 * Created by Laptop on 7/14/2014.
 */
public class CoordinateDaoImpl extends AbstractDaoImpl<Coordinate> implements CoordinateDao{

    public CoordinateDaoImpl()
    {
        super(Coordinate.class);
    }
}