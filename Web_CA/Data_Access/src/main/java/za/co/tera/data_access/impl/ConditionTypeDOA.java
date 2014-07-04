package za.co.tera.data_access.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import za.co.tera.Domain.impl.Conditiontype;
import za.co.tera.data_access.base.EntityDOA;

import java.util.List;

/**
 * Created by Laptop on 7/3/2014.
 */
public class ConditionTypeDOA implements EntityDOA<Conditiontype>{
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
    public void saveOrUpdate(Conditiontype object) {

        Session session= getSession();
        session.beginTransaction();
        session.saveOrUpdate(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Conditiontype object) {

        Session session= getSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Conditiontype find(int id) {

        Session session= getSession();
        session.beginTransaction();
        return (Conditiontype)session.get(Conditiontype.class,id);
    }

    @Override
    public List<Conditiontype> findAllObject() {
        return null;
    }

    public void insertConditionType(String conditionName,String conditionDesc)
    {
        Conditiontype conditiontype = new Conditiontype(conditionName,conditionDesc);
        Session session= getSession();
        session.beginTransaction();
        session.save(conditiontype);
        session.getTransaction().commit();

    }
}
