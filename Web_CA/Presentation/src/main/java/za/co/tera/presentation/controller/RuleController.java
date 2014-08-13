package za.co.tera.presentation.controller;

/**
 * Created by Laptop on 7/4/2014.
 */

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import za.co.tera.web_ca.business.Rule.base.RuleService;
import za.co.tera.web_ca.business.Rule.impl.RuleServiceImpl;
import za.co.tera.web_ca.domain.impl.*;

import java.util.List;

@Controller
public class RuleController {

    RuleService ruleService = new RuleServiceImpl();

    @RequestMapping(value = "/getAllRules", method = RequestMethod.GET)
    public @ResponseBody List<Rule> getAllRules( ModelMap model ) {
        return ruleService.findAllRules();
    }

    @RequestMapping(value = "/postRule", method = RequestMethod.POST)
    public @ResponseBody void postRule(@RequestBody Rule rule) {
        ruleService.createRule(rule);
    }


    @RequestMapping(value = "/getRuleByUserId/{userId}", method = RequestMethod.GET)
    public @ResponseBody
    List<Rule> getUserById( @PathVariable(value = "userId") int userId) {

        return ruleService.findRuleByUserId(userId);
    }

    @RequestMapping(value = "/AddRuleCons", method = RequestMethod.POST)
    public @ResponseBody
    int createRuleCon(@RequestBody JSONObject ruleCon) {
        boolean isNot = false;
        if (ruleCon.get("isNot").toString().equals("true"))
        {
            isNot = true;
        }
        else if (ruleCon.get("isNot").toString().equals("false"))
        {
            isNot = false;
        }
       //Rulecondition rulecondition = new Rulecondition(isNot, ruleCon.get("operation").toString(),ruleCon.get("operand").toString(),Integer.parseInt(ruleCon.get("compareValue").toString()));

        return 1;//ruleService.createRuleCon(rulecondition);
    }

    @RequestMapping(value = "/AddRuleConNeigh", method = RequestMethod.POST)
    public @ResponseBody
    void createRuleConNeigh(@RequestBody Ruleconditionneighbours ruleConNeigh) {
        ruleService.createRuleConNeigh(ruleConNeigh);
    }

    @RequestMapping(value = "/AddRuleRes", method = RequestMethod.POST)
    public @ResponseBody
    int createRuleRes(@RequestBody Ruleresult ruleRes) {
        System.out.println("CONTROLLER: ADD RULERES");

        return ruleService.createRuleRes(ruleRes);
    }

    @RequestMapping(value = "/AddRuleResNeigh", method = RequestMethod.POST)
    public @ResponseBody
    void createRuleResNeigh(@RequestBody Ruleresultneighbours ruleResNeigh) {
        System.out.println("CONTROLLER: ADD RULERESNEIGH");
        ruleService.createRuleResNeigh(ruleResNeigh);
    }

    @RequestMapping(value = "/AddRule", method = RequestMethod.POST)
    public @ResponseBody
    String createRule(@RequestBody Rule rule) {
        System.out.println("CONTROLLER: ADD RULE");
       if (ruleService.createRule(rule))
           return "Rule Added";
       else
           return "Nothing added";
    }

}

