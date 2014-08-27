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
    @Override
    public List<Coordinate> findByworldId(int worldId) {
        Session session= getSession();
        Query query = session.createQuery("From Coordinate ruleRes where ruleRes.worldId = :worldId");
        query.setParameter("worldId", worldId);
        List<Coordinate> coordinateList = query.list();
        return coordinateList;
    }

    @Override
    public void saveCoordinates(World newWorld) {
        List<Coordinate> coordinateList =new ArrayList<Coordinate>();
        int worldId = 0;

        worldId = newWorld.getWorldId();
        for (int i = 0; i < newWorld.getWorldHeight(); i++) {
            for (int j = 0; j < newWorld.getWorldWidth(); j++) {
                for (int k = 0; k < newWorld.getWorldDepth(); k++) {
                    coordinateList.add(new Coordinate(i,j,k,0,worldId));
                }
            }
        }

        Session session = getSession();
        session.beginTransaction();
        session.save(coordinateList);
        session.getTransaction().commit();
    }
}
