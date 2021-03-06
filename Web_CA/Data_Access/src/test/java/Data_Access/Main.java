package Data_Access;

import za.co.tera.web_ca.data_access.WorldRulesDao;
import za.co.tera.web_ca.data_access.impl.WorldRulesDaoImpl;
import za.co.tera.web_ca.domain.impl.Worldrules;

import java.util.List;

public class Main {

    //Used for logging of something
    //private static final Logger LOGGER = LoggerFactory.getLogger(Web_ca.class);

    public static void main(final String[] args) throws Exception {

        WorldRulesDao worldDao = new WorldRulesDaoImpl();
        List<Worldrules> worldList=worldDao.findRuleByWorldId(22);
        for (Worldrules s:worldList)
        {
            System.out.println(s.getRuleId());
        }
       /* Writer writer = null;
        World world= new World("Name","Desc",2,30,30,30,31);

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("1.xml"), "utf-8"));
            writer.write("<coordinateList>\n");
            for (int i = 0; i < world.getWorldHeight(); i++) {

                for (int j = 0; j < world.getWorldHeight(); j++) {
                    for (int k = 0; k < world.getWorldDepth(); k++) {
                        writer.write("<coordinate>\n");
                        writer.write("<x>"+i+"</x>\n");
                        writer.write("<y>"+j+"</y>\n");
                        writer.write("<z>"+k+"</z>\n");
                        writer.write("<value>"+k+"</value>\n");
                        writer.write("</coordinate>\n");
                    }
                }

            }
            writer.write("</coordinateList>\n");

        } catch (IOException ex) {
            // report
        } finally {

            try {writer.close();} catch (Exception ex) {}
        }

*/
       /*WorldDao worldDao = new WorldDaoImpl();

        World world = new World("Earth","Used to test how gravity affects certain states with other states.",3,10,10,10,31);

       System.out.println(worldDao.save(world).getWorldId() );*/
       /* WorldDao worldDao = new WorldDaoImpl();
        World world=worldDao.save(new World("name", "desc",3,5,5,5,31 ));

        CoordinateDao coordinateDao = new CoordinateDaoImpl();
        coordinateDao.saveCoordinates(world);
*/
        /*

        User user = new User("John","Doe","jd@gmail.com","123","Admin");
        UserDao userDao = new UserDaoImpl();
        userDao.save(user);

        World world = new World("Earth","Used to test how gravity affects certain states with other states.",3,10,10,10,31);
        WorldDao worldDao = new WorldDaoImpl();
        worldDao.save(world);

        State state = new State("Rock","A naturally occurring solid aggregate of minerals or mineraloids.",1,"#6B2400",31);
        StateDao stateDao = new StateDaoImpl();
        stateDao.save(state);

        Rulecondition rulecondition = new Rulecondition(false,"COUNT","==",1);
        RuleConditionDao ruleConditionDao = new RuleConditionDaoImpl();
        ruleConditionDao.save(rulecondition);

        Ruleconditionneighbours ruleconditionneighbours = new Ruleconditionneighbours("00000000000000000000000000",1);
        RuleConditionNeighboursDao ruleConditionNeighboursDao = new RuleConditionNeighboursDaoImpl();
        ruleConditionNeighboursDao.save(ruleconditionneighbours);

        Ruleresult ruleresult = new Ruleresult("SUM", "==", 0);
        RuleResultDao ruleResultDao = new RuleResultDaoImpl();
        ruleResultDao.save(ruleresult);

        Ruleresultneighbours ruleresultneighbours = new Ruleresultneighbours("00000000000000000000000000",1);
        RuleResultneighboursDao ruleResultneighboursDao = new RuleResultNeighboursDaoImpl();
        ruleResultneighboursDao.save(ruleresultneighbours);


        Rule rule = new Rule("Gravity","A natural phenomenon by which all physical bodies attract each other.",1,2,3,31);
        RuleDao ruleDao = new RuleDaoImpl();
        ruleDao.save(rule);

        Coordinate coordinate = new Coordinate(0,0,0,1,1);
        CoordinateDao coordinateDao = new CoordinateDaoImpl();
        coordinateDao.save(coordinate);

        Worldrules worldrules = new Worldrules(1,14);
        WorldRulesDao worldRulesDao = new WorldRulesDaoImpl();
        worldRulesDao.save(worldrules);
        */
       /* RuleConditionDao coordinateDao = new RuleConditionDaoImpl();
        Rulecondition coordinate =coordinateDao.findById(2);
        System.out.println(coordinate.getNeighboursId());
*/
    }
}
