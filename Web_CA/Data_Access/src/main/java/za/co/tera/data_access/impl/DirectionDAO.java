package za.co.tera.Data_Access.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import za.co.tera.Domain.impl.Direction;
import za.co.tera.Data_Access.base.EntityDAO;

import java.util.List;

/**
 * Created by Christo on 2014/07/10.
 */
public class DirectionDAO implements EntityDAO<Direction> {
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
        session.beginTransaction();
        session.saveOrUpdate(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Direction object) {

        Session session= getSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Direction find(int id) {

        Session session= getSession();
        session.beginTransaction();
        return (Direction)session.get(Direction.class,id);
    }

    @Override
    public List<Direction> findAllObject() {
        Session session= getSession();
        Query query = session.createQuery("from Direction");
        List<Direction> directionList = query.list();
        return directionList;
    }

    public void insertDirection(String directionDesc)
    {
        Direction direction = new Direction(directionDesc);
        Session session= getSession();
        session.beginTransaction();
        session.save(direction);
        session.getTransaction().commit();
    }
}
