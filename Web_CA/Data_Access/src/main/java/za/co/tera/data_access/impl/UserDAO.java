package za.co.tera.data_access.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import za.co.tera.Domain.impl.User;
import za.co.tera.data_access.base.EntityDAO;

import java.util.List;

@SuppressWarnings("deprecation")
public class UserDAO implements EntityDAO<User> {
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
    public void saveOrUpdate(User object) {

        Session session= getSession();
        session.beginTransaction();
        session.saveOrUpdate(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(User object) {

        Session session= getSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public User find(int id) {

        Session session= getSession();
        session.beginTransaction();
        return (User)session.get(User.class,id);
    }

    @Override
    public List<User> findAllObject() {
       Session session= getSession();
        Query query = session.createQuery("from User");
        List<User> userList = query.list();
        return userList;
    }

    public void insertUser(String userFirstName,String userLastName,String userEmail,String userPassword,String userRole)
    {
        User user = new User(userFirstName,userLastName,userEmail,userPassword,userRole);
        Session session= getSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }
}
