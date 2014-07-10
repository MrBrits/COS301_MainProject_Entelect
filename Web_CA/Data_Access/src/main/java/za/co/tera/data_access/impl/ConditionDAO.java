package za.co.tera.data_access.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import za.co.tera.Domain.impl.Condition;
import za.co.tera.data_access.base.EntityDAO;

import java.util.List;
@SuppressWarnings("deprecation")
public class ConditionDAO implements EntityDAO<Condition> {
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
        session.beginTransaction();
        session.saveOrUpdate(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Condition object) {

        Session session= getSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Condition find(int id) {

        Session session= getSession();
        session.beginTransaction();
        return (Condition)session.get(Condition.class,id);
    }

    @Override
    public List<Condition> findAllObject() {
        Session session= getSession();
        Query query = session.createQuery("from Condition");
        List<Condition> conditionList = query.list();
        return conditionList;
    }

    public void insertCondition(int stateToBeFound, int amountToBeFound,int directionId,int conditionTypeId,int ruleId)
    {
        Condition condition = new Condition(1,5,1,1,1);
        Session session= getSession();
        session.beginTransaction();
        session.save(condition);
        session.getTransaction().commit();
    }
}
