package za.co.tera.data_access.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import za.co.tera.Domain.impl.Direction;
import za.co.tera.data_access.base.EntityDOA;

import java.util.List;

/**
 * Created by Laptop on 7/3/2014.
 */
public class DirectionDOA implements EntityDOA<Direction> {
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
    public void saveOrUpdate(Direction object) {
        Session session= getSession();
    }

    @Override
    public void delete(Direction object) {
        Session session= getSession();
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
        Session session= getSession();
        session.beginTransaction();
        session.save(direction);
        session.getTransaction().commit();
    }
}
