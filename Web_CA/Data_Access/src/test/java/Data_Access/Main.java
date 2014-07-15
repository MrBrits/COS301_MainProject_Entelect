package Data_Access;

import za.co.tera.web_ca.data_access.UserDao;
import za.co.tera.web_ca.data_access.impl.UserDaoImpl;

public class Main {

    //Used for logging of something
    //private static final Logger LOGGER = LoggerFactory.getLogger(Web_ca.class);

    public static void main(final String[] args) throws Exception {

        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.validateLogin("evf","efv"));




        /*Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        session.beginTransaction();


        za.co.tera.Business.User user = new za.co.tera.Business.User();
        user.setUserEmail("john@gmail.com");
        user.setUserFirstName("John");
        user.setUserLastName("Doe");
        user.setUserPassword("12345");
        user.setUserRole("Admin");
        session.save(user);

/*
        za.co.tera.Business.za.co.tera.Business.World world = new za.co.tera.Business.za.co.tera.Business.World();
        world.setWorldName("Falling Object");
        world.setWorldDesc("USed to test how gravity affects certain states with other states.");
        world.setWorldDimension(2);
        world.setWorldWidth(1);
        world.setWorldHeight(2);
        world.setWorldLength(0);
        world.setOwnerId(5);
        session.save(world);


        za.co.tera.Business.State state = new za.co.tera.Business.State();
        state.setOwnerId(5);
        state.setStateName("Rock");
        state.setStateDesc("A naturally occurring solid aggregate of minerals or mineraloids.");
        state.setStateRgb("102,51,0");
        state.setStateValue(1.5);
        session.save(state);


        za.co.tera.Business.State state2 = new za.co.tera.Business.State();
        state2.setOwnerId(5);
        state2.setStateName("Air");
        state2.setStateDesc("Mainly composed of nitrogen, oxygen and argon.");
        state2.setStateRgb("204,204,255");
        state2.setStateValue(0.1);
//        session.save(state2);


        Direction direct = new Direction();
        direct.setDirectionName("Down");
        session.save(direct);


     /*   za.co.tera.Business.Rule rule = new za.co.tera.Business.Rule();
        rule.setRuleName("Gravity");
        rule.setRuleDesc("A natural phenomenon by which all physical bodies attract each other.");
        rule.setPriority(1);
        rule.setCurrentValue(2);
        rule.setNextValue(3);
        rule.setWorldID(2);
        rule.setOwnerId(5);
        session.save(rule);

        Conditiontype conditionType = new Conditiontype();
        conditionType.setConditionName("Count");
        conditionType.setConditionDesc("Used to count the amount of certain state values.");
        session.save(conditionType);

        /* PROBLEM WITH SQL SYNTAX - HAD TO ADD IT MANUALLY**//*
        Condition condition = new Condition();
        condition.setStateToBeFound(3);
        condition.setAmountToBeFound(1);
        condition.setDirectionId(5);
        condition.setConditionTypeId(1);
        condition.setRuleID(2);
        session.save(condition);

        za.co.tera.Business.Coordinate coordinate = new za.co.tera.Business.Coordinate();
        coordinate.setCoordinateX(0);
        coordinate.setCoordinateY(0);
        coordinate.setCoordinateZ(-1);
        coordinate.setStateId(2);
        coordinate.setWorldID(2);
        session.save(coordinate);


        za.co.tera.Business.Coordinate coordinate2 = new za.co.tera.Business.Coordinate();
        coordinate2.setCoordinateX(0);
        coordinate2.setCoordinateY(1);
        coordinate2.setCoordinateZ(-1);
        coordinate2.setStateId(3);
        coordinate2.setWorldID(2);
        session.save(coordinate2);

*/
               /* for(Iterator<za.co.tera.Business.User> i = users.iterator(); i.hasNext(); ) {
            za.co.tera.Business.User item = (za.co.tera.Business.User)i.next();
            System.out.println(item.getUserFirstName()+" "+item.getUserLastName());
        }*/
        //Net probleme with fk--------------------------------------------
/*
        UserDAO userDAO = new UserDAO();
        userDAO.insertUser("Stephan..","Viljoen","email","pass","admin");
        WorldDAO worldDAO = new WorldDAO();
        worldDAO.insertWorld("Game of live","live/dead",1,10,10,10,1);
        StateDAO stateDAO = new StateDAO();
        stateDAO.insertState("Dead","dead",1.0,"255,255,255",1);
        CoordinateDAO coordinateDAO = new CoordinateDAO();
        coordinateDAO.insertCoordinate(0,0,0,1,1);

        RuleDAO ruleDAO = new RuleDAO();
        ruleDAO.insertRule("Progress","progress",1,1,1,1,1);

        DirectionDAO directionDAO = new DirectionDAO();
        directionDAO.insertDirection("0000000000000011111111111111");
        RuleConditionDAO ruleConditionDAO = new RuleConditionDAO();
        ruleConditionDAO.insertRulecondition(5,1,1,6,1);*/
    }
}
