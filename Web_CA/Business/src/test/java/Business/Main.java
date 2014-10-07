package Business;

import za.co.tera.web_ca.business.World.base.WorldService;
import za.co.tera.web_ca.business.World.impl.WorldServiceImpl;

public class Main {
    public static void main(String[] args) throws Exception {
       /* WorldService stateService = new WorldServiceImpl();
        UserService userServiceer= new UserServiceImpl();

        World world = new World("world","world",2,5,5,5,23);
        stateService.createWorld(world);*/
       /* ruleWrapper ruleWrappers = new ruleWrapper();
        ruleWrappers.condition("when false avg of 1;4:8 between 7 10 or false avg of 15:20 between 7 12");
        ruleWrappers.condition("then avg of 1;4:8 = 1");
        ruleWrappers.condition("identifiedBy Test test");*/
        WorldService worldService = new WorldServiceImpl();
        worldService.ImportWorld(9273,22);
       // Rule rule= new Rule("ddf","fgf",2,3,null,2,11118);
       /// RuleService ruleService = new RuleServiceImpl();
        //ruleService.createRule(rule);
        //  runner.condition("when true sum of 1;4:8 between 1 3");
//  runner.condition("then sum of 1;4:8 = 1");
// runner.condition("identifiedBy rule1 fdfdf");

    }
}
