package Data_Access;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import za.co.tera.Data_Access.impl.Direction;
import za.co.tera.Data_Access.impl.State;
import za.co.tera.Data_Access.impl.User;

public class Main {

    //private static final Logger LOGGER = LoggerFactory.getLogger(Web_ca.class);

    public static void main(final String[] args) throws Exception {
        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        session.beginTransaction();

        State state = new State();
        state.setOwnerId(18);
        state.setStateDesc("gravity");
        state.setStateName("Gravity");
        state.setStateRgb("12345");
        state.setStateValue(1.1);
        User user = new User();
        user.setUserEmail("@gmail");
        user.setUserFirstName("John");
        user.setUserLastName("Doe");
        user.setUserPassword("1234");


        Direction direct = new Direction();
        direct.setDirectionName("up");

        //session.save(direct);
        session.save(state);
        session.getTransaction().commit();
    }
}
