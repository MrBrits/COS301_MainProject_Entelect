package za.co.tera.data_access.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import za.co.tera.Domain.impl.Coordinate;
import za.co.tera.data_access.base.EntityDOA;

import java.util.List;

/**
 * Created by Laptop on 7/3/2014.
 */
public class CoordinateDOA implements EntityDOA<Coordinate> {
    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }
    @Override
    public void saveOrUpdate(Coordinate object) {
        Session session= getSession();
    }

    @Override
    public void delete(Coordinate object) {
        Session session= getSession();
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
        Session session= getSession();
        session.beginTransaction();
        session.save(coordinate);
        session.getTransaction().commit();
    }
}
