package za.co.tera.data_access.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import za.co.tera.Domain.impl.Condition;
import za.co.tera.data_access.base.EntityDOA;

import java.util.List;

/**
 * Created by Laptop on 7/3/2014.
 */
public class ConditionDOA  implements EntityDOA<Condition>{
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
    public void saveOrUpdate(Condition object) {
        Session session= getSession();
    }

    @Override
    public void delete(Condition object) {
        Session session= getSession();
    }

    @Override
    public Condition find(int id) {
        return new Condition();
    }

    @Override
    public List<Condition> findAllObject() {
        return null;
    }
    public void insertCondition(int stateToBeFound, int amountToBeFound,int directionId,int conditionTypeId,int ruleId)
    {
        Condition condition = new Condition(stateToBeFound,amountToBeFound,directionId,conditionTypeId,ruleId);
        Session session= getSession();
        session.beginTransaction();
        session.save(condition);
        session.getTransaction().commit();
    }
}
