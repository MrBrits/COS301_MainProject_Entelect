package za.co.tera.web_ca.data_access.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import za.co.tera.web_ca.data_access.CoordinateDao;
import za.co.tera.web_ca.data_access.base.impl.AbstractDaoImpl;
import za.co.tera.web_ca.domain.impl.Coordinate;

import java.util.List;

public class CoordinateDaoImpl extends AbstractDaoImpl<Coordinate> implements CoordinateDao{


    public CoordinateDaoImpl()
    {
        super(Coordinate.class);
    }
    @Override
    public List<Coordinate> findByworldId(int worldId) {
        Session session= getSession();
        Query query = session.createQuery("From Coordinate ruleRes where ruleRes.worldId = :worldId");
        query.setParameter("worldId", worldId);
        List<Coordinate> coordinateList = query.list();
        return coordinateList;
    }
}
