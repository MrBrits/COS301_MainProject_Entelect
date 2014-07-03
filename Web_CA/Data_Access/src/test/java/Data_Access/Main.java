package Data_Access;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import za.co.tera.Domain.impl.*;

public class Main {

    //Used for logging of something
    //private static final Logger LOGGER = LoggerFactory.getLogger(Web_ca.class);

    public static void main(final String[] args) throws Exception {
        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        session.beginTransaction();


        User user = new User();
        user.setUserEmail("john@gmail.com");
        user.setUserFirstName("John");
        user.setUserLastName("Doe");
        user.setUserPassword("12345");
        user.setUserRole("Admin");
        session.save(user);

        /*
        World world = new World();
        world.setWorldName("Falling Object");
        world.setWorldDesc("USed to test how gravity affects certain states with other states.");
        world.setWorldDimension(2);
        world.setWorldWidth(1);
        world.setWorldHeight(2);
        world.setWorldLength(0);
        world.setOwnerId(5);
        session.save(world);
        */
        /*
        State state = new State();
        state.setOwnerId(5);
        state.setStateName("Rock");
        state.setStateDesc("A naturally occurring solid aggregate of minerals or mineraloids.");
        state.setStateRgb("102,51,0");
        state.setStateValue(1.5);
        session.save(state);
        */
        /*
        State state2 = new State();
        state2.setOwnerId(5);
        state2.setStateName("Air");
        state2.setStateDesc("Mainly composed of nitrogen, oxygen and argon.");
        state2.setStateRgb("204,204,255");
        state2.setStateValue(0.1);
        session.save(state2);
        */
        /*
        Direction direct = new Direction();
        direct.setDirectionName("Down");
        session.save(direct);
        */
         /*
        Rule rule = new Rule();
        rule.setRuleName("Gravity");
        rule.setRuleDesc("A natural phenomenon by which all physical bodies attract each other.");
        rule.setPriority(1);
        rule.setCurrentValue(2);
        rule.setNextValue(3);
        rule.setWorldID(2);
        rule.setOwnerId(5);
        session.save(rule);
        */
        /*
        Conditiontype conditionType = new Conditiontype();
        conditionType.setConditionName("Count");
        conditionType.setConditionDesc("Used to count the amount of certain state values.");
        session.save(conditionType);
        */
        /* PROBLEM WITH SQL SYNTAX - HAD TO ADD IT MANUALLY
        Condition condition = new Condition();
        condition.setStateToBeFound(3);
        condition.setAmountToBeFound(1);
        condition.setDirectionId(5);
        condition.setConditionTypeId(1);
        condition.setRuleID(2);
        session.save(condition);
        */
        /*
        Coordinate coordinate = new Coordinate();
        coordinate.setCoordinateX(0);
        coordinate.setCoordinateY(0);
        coordinate.setCoordinateZ(-1);
        coordinate.setStateId(2);
        coordinate.setWorldID(2);
        session.save(coordinate);
        */
        /*
        Coordinate coordinate2 = new Coordinate();
        coordinate2.setCoordinateX(0);
        coordinate2.setCoordinateY(1);
        coordinate2.setCoordinateZ(-1);
        coordinate2.setStateId(3);
        coordinate2.setWorldID(2);
        session.save(coordinate2);
        */

        session.getTransaction().commit();
    }
}
