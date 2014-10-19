package Business;

import za.co.tera.web_ca.business.Rule.impl.ruleWrapper;

public class Main {
    public static void main(String[] args) throws Exception {
/*
        ruleWrapper ruleWrappers = new ruleWrapper();
        ruleWrappers.condition("if false avg of 1;4:8 bi 7 10 or false avg of 15:20 bi 7 12");
        ruleWrappers.condition("then = 5");
        ruleWrappers.condition("identifiedBy Test test dfdf df");
*/
        ruleWrapper ruleWrappers = new ruleWrapper();
        ruleWrappers.condition("if false avg of 1;4:8 < 7");
        ruleWrappers.condition("then avg of 1;4:8");
        ruleWrappers.condition("identifiedBy Test test");

        return;
    }
}

