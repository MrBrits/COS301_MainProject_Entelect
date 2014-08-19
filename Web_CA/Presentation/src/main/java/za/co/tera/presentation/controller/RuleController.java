package za.co.tera.presentation.controller;

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

    @RequestMapping(value = "/AddRuleConNeigh", method = RequestMethod.POST)
    public @ResponseBody
    int createRuleConNeigh(@RequestBody Ruleconditionneighbours ruleConNeigh) {
        return ruleService.createRuleConNeigh(ruleConNeigh);
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
        Rulecondition rulecondition = new Rulecondition(isNot, ruleCon.get("operation").toString(),ruleCon.get("operand").toString(),Integer.parseInt(ruleCon.get("compareValue").toString()),Integer.parseInt(ruleCon.get("neighboursId").toString()));
        return ruleService.createRuleCon(rulecondition);
    }

    @RequestMapping(value = "/AddRuleResNeigh", method = RequestMethod.POST)
    public @ResponseBody
    int createRuleResNeigh(@RequestBody Ruleresultneighbours ruleResNeigh) {
        return ruleService.createRuleResNeigh(ruleResNeigh);
    }

    @RequestMapping(value = "/AddRuleRes", method = RequestMethod.POST)
    public @ResponseBody
    int createRuleRes(@RequestBody Ruleresult ruleRes) {
        return ruleService.createRuleRes(ruleRes);
    }

    @RequestMapping(value = "/AddRule", method = RequestMethod.POST)
    public @ResponseBody
    String createRule(@RequestBody Rule rule) {
        if (ruleService.createRule(rule))
            return "Rule " + rule.getRuleName() +" Added";

        return "No new Rule has been added";
    }
    @RequestMapping(value = "/ruleWorld/{ruleId}", method = RequestMethod.GET)
    public @ResponseBody
    String deleteRule( @PathVariable(value = "ruleId") int ruleId) {
        ruleService.deleteRule(ruleService.findRule(ruleId));
        return "done";
    }
}

