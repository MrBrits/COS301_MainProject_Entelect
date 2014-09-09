package za.co.tera.web_ca.data_access.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import za.co.tera.web_ca.data_access.CoordinateDao;
import za.co.tera.web_ca.data_access.base.impl.AbstractDaoImpl;
import za.co.tera.web_ca.domain.impl.Coordinate;
import za.co.tera.web_ca.domain.impl.World;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CoordinateDaoImpl extends AbstractDaoImpl<Coordinate> implements CoordinateDao{


    public CoordinateDaoImpl()
    {
        super(Coordinate.class);
    }

}
