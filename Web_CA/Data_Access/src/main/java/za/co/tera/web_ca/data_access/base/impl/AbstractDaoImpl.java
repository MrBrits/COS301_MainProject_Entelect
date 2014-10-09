package za.co.tera.web_ca.data_access.base.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import za.co.tera.web_ca.data_access.base.AbstractDao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Laptop on 7/14/2014.
 */
public class AbstractDaoImpl<T extends Serializable> implements AbstractDao<T>
{
    private Class<T> type;
    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;
   /*private static final SessionFactory sessionFactory = buildSessionFactory1();

    private static SessionFactory buildSessionFactory1() {

        Configuration configuration = new Configuration().configure(); // configuration
        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static void shutdown() {
        sessionFactory.close();
    }
    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }*/
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
    public AbstractDaoImpl()
    {

    }
    public AbstractDaoImpl(Class<T> type)
    {
        this.type = type;
    }
    @Override
    public T findById(int id) {
        Session session= getSession();
        session.beginTransaction();
        return (T)session.get(type,id);
    }

    @Override
    public List<T> findAll() {
        Session session= getSession();
        Query query = session.createQuery("from " + type.getSimpleName());
        List<T> objects = query.list();
        return objects;
    }

    @Override
    public T save(T object) {
        if(object!=null) {
            Session session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(object);
            session.getTransaction().commit();
            Query query = session.createQuery("from " + type.getSimpleName());
            List<T> objects = query.list();
            return objects.get(objects.size()-1);

        }
        return null;
    }



    @Override
    public void delete(T object) {
        Session session= getSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public long count() {
        Session session= getSession();
        Query query = session.createQuery("from "+type.getSimpleName());
        return query.list().size();
    }
}
