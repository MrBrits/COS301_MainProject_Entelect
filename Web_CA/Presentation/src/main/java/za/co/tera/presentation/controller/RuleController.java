package za.co.tera.presentation.controller;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import za.co.tera.web_ca.business.Rule.base.RuleService;
import za.co.tera.web_ca.business.Rule.impl.RuleServiceImpl;
import za.co.tera.web_ca.business.Rule.impl.ruleWrapper;
import za.co.tera.web_ca.domain.impl.*;

import java.util.List;

@Controller
public class RuleController {

    RuleService ruleService = new RuleServiceImpl();
    ruleWrapper ruleWrapper = new ruleWrapper();

    String NeighbourString = "000000000000000000000000000";
    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/getAllRules", method = RequestMethod.POST)
    public @ResponseBody List<Rule> getAllRules( ModelMap model ) {
        return ruleService.findAllRules();
    }

    /**
     *
     * @param rule
     */
    @RequestMapping(value = "/postRule", method = RequestMethod.POST)
    public @ResponseBody void postRule(@RequestBody Rule rule) {
        ruleService.createRule(rule);
    }

    /**
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getRuleByUserId", method = RequestMethod.POST)
    public @ResponseBody
    List<Rule> getUserById(@RequestBody int userId) {

        return ruleService.findRuleByUserId(userId);
    }

    /**
     *
     * @param rawRuleConNeigh
     * @return
     */
    @RequestMapping(value = "/AddRuleConNeigh", method = RequestMethod.POST)
    public @ResponseBody
    int createRuleConNeigh(@RequestBody String rawRuleConNeigh) {

        /*
        NeighbourString = "000000000000000000000000000";
        int endOfString = rawRuleConNeigh.lastIndexOf("}");
        String realNeighbours = rawRuleConNeigh.substring(15,(endOfString-1));
        //System.out.println(realNeighbours);

        String[] neighbours = realNeighbours.split(";");
        for (int i = 0; i < neighbours.length; i++) {

            //System.out.println("[" + i + "] - " +neighbours[i]);
            if (neighbours[i].contains("-")) {
                NeighbourString = returnNeighbour(Integer.parseInt(neighbours[i].split("-")[0]) - 1, Integer.parseInt(neighbours[i].split("-")[1]));
            } else if (isNumeric(neighbours[i])) {
                NeighbourString = returnNeighbour(Integer.parseInt(neighbours[i]) - 1, Integer.parseInt(neighbours[i]));
            } else {
                return -9999;
            }
        }

        //System.out.println(NeighbourString);
        */
        Ruleneighbours ruleNeigh = new Ruleneighbours();
        ruleNeigh.setNeighbours(rawRuleConNeigh);

        return ruleService.createRuleNeigh(ruleNeigh);
    }

    public String returnNeighbour(int begin, int end) {
        for (int i = begin; i < end; i++) {
            char[] myNameChars = NeighbourString.toCharArray();
            myNameChars[i] = '1';
            NeighbourString = String.valueOf(myNameChars);
        }
        return NeighbourString;
    }

    public static boolean isNumeric(String str) {
        try {
            double digit = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param ruleCon
     * @return
     */
    @RequestMapping(value = "/AddRuleCon", method = RequestMethod.POST)
    public @ResponseBody
    int createRuleCon(@RequestBody JSONObject ruleCon) {
        boolean isNot = false;
        Double compareValueTwo = null;
        if (ruleCon.get("isNot").toString().equals("true"))
        {
            isNot = true;
        }
        else if (ruleCon.get("isNot").toString().equals("false"))
        {
            isNot = false;
        }

        if (ruleCon.get("compareValueTwo").equals(-9999))
        {
            compareValueTwo = null;
        }
        else
        {
            compareValueTwo = Double.parseDouble(ruleCon.get("compareValueTwo").toString());
        }
        Rulecondition newRuleCon = new Rulecondition(isNot, ruleCon.get("operation").toString(),Integer.parseInt(ruleCon.get("neighboursId").toString()),ruleCon.get("operand").toString(),Double.parseDouble(ruleCon.get("compareValueOne").toString()), compareValueTwo);


        return ruleService.createRuleCon(newRuleCon);
    }

    @RequestMapping(value = "/AddRuleConAndOrNeigh", method = RequestMethod.POST)
    public @ResponseBody
    int createRuleConAndOrNeigh(@RequestBody String rawRuleConAndOrNeigh) {

        /*
        NeighbourString = "000000000000000000000000000";
        int endOfString = rawRuleConAndOrNeigh.lastIndexOf("}");
        String realNeighbours = rawRuleConAndOrNeigh.substring(15,(endOfString-1));
        //System.out.println(realNeighbours);

        String[] neighbours = realNeighbours.split(";");
        for (int i = 0; i < neighbours.length; i++) {

            //System.out.println("[" + i + "] - " +neighbours[i]);
            if (neighbours[i].contains("-")) {
                NeighbourString = returnNeighbour(Integer.parseInt(neighbours[i].split("-")[0]) - 1, Integer.parseInt(neighbours[i].split("-")[1]));
            } else if (isNumeric(neighbours[i])) {
                NeighbourString = returnNeighbour(Integer.parseInt(neighbours[i]) - 1, Integer.parseInt(neighbours[i]));
            } else {
                return -9999;
            }
        }

        //System.out.println(NeighbourString);
        */
        Ruleneighbours ruleNeigh = new Ruleneighbours();
        ruleNeigh.setNeighbours(rawRuleConAndOrNeigh);

        return ruleService.createRuleNeigh(ruleNeigh);
    }

    @RequestMapping(value = "/createRuleByString", method = RequestMethod.POST)
    public @ResponseBody
    String createRuleByString(@RequestBody String ruleString) throws Exception {

        System.out.println( "Done");
        String lines[] = ruleString.split("br");
        for (int i = 0; i < lines.length; i++) {

            System.out.println(lines[i]);
        }
        for (int i = 0; i < lines.length; i++) {
            ruleWrapper.condition(lines[i]);
            System.out.println(lines[i]);
        }
        return "Done";

    }

    @RequestMapping(value = "/AddRuleConAndOr", method = RequestMethod.POST)
    public @ResponseBody
    int createRuleConAndOr(@RequestBody JSONObject ruleConAndOr) {
        boolean isNot = false;
        Double compareValueTwo = null;
        if (ruleConAndOr.get("isNot").toString().equals("true"))
        {
            isNot = true;
        }
        else if (ruleConAndOr.get("isNot").toString().equals("false"))
        {
            isNot = false;
        }

        if (ruleConAndOr.get("compareValueTwo").equals(-9999))
        {
            compareValueTwo = null;
        }
        else
        {
            compareValueTwo = Double.parseDouble(ruleConAndOr.get("compareValueTwo").toString());
        }
        Rulecondition newRuleConAndOr = new Rulecondition(isNot, ruleConAndOr.get("operation").toString(),Integer.parseInt(ruleConAndOr.get("neighboursId").toString()),ruleConAndOr.get("operand").toString(),Double.parseDouble(ruleConAndOr.get("compareValueOne").toString()), compareValueTwo);


        return ruleService.createRuleCon(newRuleConAndOr);
    }


    /**
     *
     * @param rawRuleResNeigh
     * @return
     */
    @RequestMapping(value = "/AddRuleResNeigh", method = RequestMethod.POST)
    public @ResponseBody
    int createRuleResNeigh(@RequestBody String rawRuleResNeigh) {
        /*
        NeighbourString = "000000000000000000000000000";
        int endOfString = rawRuleResNeigh.lastIndexOf("}");
        String realNeighbours = rawRuleResNeigh.substring(15,(endOfString-1));
        //System.out.println(realNeighbours);

        String[] neighbours = realNeighbours.split(";");
        for (int i = 0; i < neighbours.length; i++) {

            //System.out.println("[" + i + "] - " +neighbours[i]);
            if (neighbours[i].contains("-")) {
                NeighbourString = returnNeighbour(Integer.parseInt(neighbours[i].split("-")[0]) - 1, Integer.parseInt(neighbours[i].split("-")[1]));
            } else if (isNumeric(neighbours[i])) {
                NeighbourString = returnNeighbour(Integer.parseInt(neighbours[i]) - 1, Integer.parseInt(neighbours[i]));
            } else {
                return -9999;
            }
        }

        //System.out.println(NeighbourString);
        */
        Ruleneighbours ruleNeigh = new Ruleneighbours();
        ruleNeigh.setNeighbours(rawRuleResNeigh);

        return ruleService.createRuleNeigh(ruleNeigh);
    }

    /**
     *
     * @param ruleRes
     * @return
     */
    @RequestMapping(value = "/AddRuleRes", method = RequestMethod.POST)
    public @ResponseBody
    int createRuleRes(@RequestBody Ruleresult ruleRes) {
        if (ruleRes.getNeighboursId() == -9999){
            ruleRes.setNeighboursId(null);
        }
        if (ruleRes.getResultValue() == -9999){
            ruleRes.setResultValue(null);
        }
        if (ruleRes.getOperation().equals("NULL")){
            ruleRes.setOperation(null);
        }

        /*
        System.out.println("NEIGH: " + ruleRes.getNeighboursId());
        System.out.println("VALUE: " + ruleRes.getResultValue());
        System.out.println("OPERATION: " + ruleRes.getOperation());
        */

        return ruleService.createRuleRes(ruleRes);
    }

    /**
     *
     * @param rule
     * @return
     */
    @RequestMapping(value = "/AddRule", method = RequestMethod.POST)
    public @ResponseBody
    String createRule(@RequestBody JSONObject rule) {
        Integer ruleConAndId = null;
        Integer ruleConOrId = null;

        if (rule.get("ruleConAndId").equals(-9999))
        {
            ruleConAndId = null;
        }
        else
        {
            ruleConAndId = Integer.parseInt(rule.get("ruleConAndId").toString());
        }

        if (rule.get("ruleConOrId").equals(-9999))
        {
            ruleConOrId = null;
        }
        else
        {
            ruleConOrId = Integer.parseInt(rule.get("ruleConOrId").toString());
        }

        Rule newRule = new Rule(rule.get("ruleName").toString(),rule.get("ruleDesc").toString(),Integer.parseInt(rule.get("ruleConId").toString()),ruleConAndId,ruleConOrId,Integer.parseInt(rule.get("ruleResId").toString()),Integer.parseInt(rule.get("ownerId").toString()));

        if (ruleService.createRule(newRule))
            return "Rule added";

        return "SERVER ERROR: No new Rule has been added. Please contact support.";
    }

    /**
     *
     * @param ruleId
     * @return
     */
    @RequestMapping(value = "/deleteRule", method = RequestMethod.POST)
    public @ResponseBody
    String deleteRule( @RequestBody int ruleId) {
        ruleService.deleteRule(ruleService.findRule(ruleId));
        return "Rule deleted";
    }



    @RequestMapping(value = "/findRuleByWorldId", method = RequestMethod.POST)
    public @ResponseBody
    List<Worldrules> findRuleByWorldId( @RequestBody int worldId) {
       //System.out.println("hjh");
        return ruleService.findRuleByWorldId(worldId);
    }


    @RequestMapping(value = "/getRuleById", method = RequestMethod.POST)
    public @ResponseBody
    Rule getRuleById( @RequestBody int ruleId) {
        return ruleService.findRule(ruleId);
    }

    @RequestMapping(value = "/getRuleConById", method = RequestMethod.POST)
    public @ResponseBody
    Rulecondition getRuleConById( @RequestBody int ruleConId) {
        return ruleService.findRuleCon(ruleConId);
    }

    @RequestMapping(value = "/getRuleResById", method = RequestMethod.POST)
    public @ResponseBody
    Ruleresult getRuleResById( @RequestBody int ruleResId) {
        return ruleService.findRuleRes(ruleResId);
    }


    @RequestMapping(value = "/getConditions", method = RequestMethod.POST)
    public @ResponseBody
    List<Rulecondition> getConditions( ) {

        return ruleService.findAllConditions();
    }

    @RequestMapping(value = "/getRuleConNeighById", method = RequestMethod.POST)
     public @ResponseBody
     Ruleneighbours getRuleConNeighById( @RequestBody Integer ruleConNeighId) {
        return ruleService.findRuleNeigh(ruleConNeighId);
    }

    @RequestMapping(value = "/getRuleResNeighById", method = RequestMethod.POST)
    public @ResponseBody
    Ruleneighbours getRuleResNeighById( @RequestBody Integer ruleResNeighId) {
        if (ruleResNeighId == -9999)
        {
            return null;
        }
        return ruleService.findRuleNeigh(ruleResNeighId);
    }

}

