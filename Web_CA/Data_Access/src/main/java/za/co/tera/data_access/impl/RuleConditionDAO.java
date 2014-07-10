package za.co.tera.data_access.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import za.co.tera.Domain.impl.Rulecondition;
import za.co.tera.data_access.base.EntityDAO;

import java.util.List;

/**
 * Created by Christo on 2014/07/10.
 */
public class RuleConditionDAO implements EntityDAO<Rulecondition> {
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
    public void saveOrUpdate(Rulecondition object) {

        Session session= getSession();
        session.beginTransaction();
        session.saveOrUpdate(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Rulecondition object) {

        Session session= getSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Rulecondition find(int id) {

        Session session= getSession();
        session.beginTransaction();
        return (Rulecondition)session.get(Rulecondition.class,id);
    }

    @Override
    public List<Rulecondition> findAllObject() {
        Session session= getSession();
        Query query = session.createQuery("from Rulecondition");
        List<Rulecondition> ruleCondtionList = query.list();
        return ruleCondtionList;
    }

    public void insertRulecondition(int amountToFind, int stateToFind, int conditionTypeId, int directionId, int ruleId)
    {
        Rulecondition ruleCondtion = new Rulecondition(amountToFind, stateToFind, conditionTypeId, directionId, ruleId);
        Session session= getSession();
        session.beginTransaction();
        session.save(ruleCondtion);
        session.getTransaction().commit();
    }
}
