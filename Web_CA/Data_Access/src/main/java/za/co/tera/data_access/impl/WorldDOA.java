package za.co.tera.data_access.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import za.co.tera.Domain.impl.World;
import za.co.tera.data_access.base.EntityDOA;

import java.util.List;

/**
 * Created by Laptop on 7/3/2014.
 */
public class WorldDOA implements EntityDOA<World>{
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
    public void saveOrUpdate(World object) {
        Session session= getSession();
    }

    @Override
    public void delete(World object) {
        Session session= getSession();
    }

    @Override
    public World find(int id) {
        return new World();
    }

    @Override
    public List<World> findAllObject() {
        return null;
    }
    public void insertWorld(String worldName,String worldDesc,int worldDimension,int worldWidth,int worldHeight,int worldLength,int ownerId)
    {
        World world = new World(worldName,worldDesc,worldDimension,worldWidth,worldHeight,worldLength,ownerId);
        Session session= getSession();
        session.beginTransaction();
        session.save(world);
        session.getTransaction().commit();
    }
}
