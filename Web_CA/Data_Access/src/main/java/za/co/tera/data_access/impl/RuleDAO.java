package za.co.tera.data_access.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import za.co.tera.Domain.impl.Rule;
import za.co.tera.data_access.base.EntityDAO;

import java.util.List;

@SuppressWarnings("deprecation")
public class RuleDAO implements EntityDAO<Rule> {
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
    public void saveOrUpdate(Rule object) {

        Session session= getSession();
        session.beginTransaction();
        session.saveOrUpdate(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Rule object) {

        Session session= getSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Rule find(int id) {

        Session session= getSession();
        session.beginTransaction();
        return (Rule)session.get(Rule.class,id);
    }

    @Override
    public List<Rule> findAllObject() {
        return null;
    }

    public void insertRule(String ruleName,String ruleDesc,int priority,int currentValue,int nextValue,int worldId,int ownerId)
    {
        Rule rule = new Rule( ruleName,ruleDesc,priority,currentValue,nextValue,worldId,ownerId);
        Session session= getSession();
        session.beginTransaction();
        session.save(rule);
        session.getTransaction().commit();
    }
}
