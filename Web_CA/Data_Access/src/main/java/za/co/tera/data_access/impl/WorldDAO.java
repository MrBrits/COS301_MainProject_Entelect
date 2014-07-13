package za.co.tera.data_access.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import za.co.tera.Domain.impl.World;
import za.co.tera.data_access.base.EntityDAO;

import java.util.List;

@SuppressWarnings("deprecation")
public class WorldDAO implements EntityDAO<World> {
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
        session.beginTransaction();
        session.saveOrUpdate(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(World object) {

        Session session= getSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public World find(int id) {
        Session session= getSession();
        session.beginTransaction();
        return (World)session.get(World.class,id);
    }

    @Override
    public List<World> findAllObject() {
        Session session= getSession();
        Query query = session.createQuery("from World");
        List<World> worldList = query.list();
        return worldList;
    }
    public void insertWorld(String worldName,String worldDesc,int worldDimension,int worldWidth,int worldHeight,int worldDepth,int ownerId)
    {
        World world = new World(worldName,worldDesc,worldDimension,worldWidth,worldHeight,worldDepth,ownerId);
        Session session= getSession();
        session.beginTransaction();
        session.save(world);
        session.getTransaction().commit();
    }
}
