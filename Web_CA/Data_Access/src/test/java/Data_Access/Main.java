package Data_Access;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import za.co.tera.Data_Access.impl.User;

public class Main {

    //private static final Logger LOGGER = LoggerFactory.getLogger(Web_ca.class);

    public static void main(final String[] args) throws Exception {



        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        session.beginTransaction();

        User user = new User();
        user.setUserEmail("@gmail");
        user.setUserFirstName("CHRISTO");
        user.setUserLastName("BRITS");
        user.setUserId(2);
        user.setUserPassword(12356);

        session.save(user);
        session.getTransaction().commit();




    }
}
