package Data_Access;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import za.co.tera.web_ca.domain.layer.impl.User;

/**
 * Created by Laptop on 7/1/2014.
 */
public class Main {

    public static void main(final String[] args) throws Exception {
        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();

        Session session= sessionFactory.openSession();
        session.beginTransaction();
        User user = new User();
        user.setUserEmail("email");
        user.setUserFirstName("first");
        user.setUserLastName("last");
        user.setUserId(1);
        user.setUserPassword(123);
        session.save(user);
        session.getTransaction().commit();



    }
}
