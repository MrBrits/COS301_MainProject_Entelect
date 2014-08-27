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

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/getAllRules", method = RequestMethod.GET)
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
    @RequestMapping(value = "/getRuleByUserId/{userId}", method = RequestMethod.GET)
    public @ResponseBody
    List<Rule> getUserById( @PathVariable(value = "userId") int userId) {

        return ruleService.findRuleByUserId(userId);
    }

    /**
     *
     * @param ruleConNeigh
     * @return
     */
    @RequestMapping(value = "/AddRuleConNeigh", method = RequestMethod.POST)
    public @ResponseBody
    int createRuleConNeigh(@RequestBody Ruleneighbours ruleConNeigh) {
        return ruleService.createRuleNeigh(ruleConNeigh);
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
        if (ruleCon.get("isNot").toString().equals("true"))
        {
            isNot = true;
        }
        else if (ruleCon.get("isNot").toString().equals("false"))
        {
            isNot = false;
        }
        Rulecondition rulecondition = new Rulecondition(isNot, ruleCon.get("operation").toString(),Integer.parseInt(ruleCon.get("neighboursId").toString()),ruleCon.get("operand").toString(),Double.parseDouble(ruleCon.get("compareValueOne").toString()), Double.parseDouble(ruleCon.get("compareValueTwo").toString()));
        return ruleService.createRuleCon(rulecondition);
    }

    /**
     *
     * @param ruleResNeigh
     * @return
     */
    @RequestMapping(value = "/AddRuleResNeigh", method = RequestMethod.POST)
    public @ResponseBody
    int createRuleResNeigh(@RequestBody Ruleneighbours ruleResNeigh) {
        return ruleService.createRuleNeigh(ruleResNeigh);
    }

    /**
     *
     * @param ruleRes
     * @return
     */
    @RequestMapping(value = "/AddRuleRes", method = RequestMethod.POST)
    public @ResponseBody
    int createRuleRes(@RequestBody Ruleresult ruleRes) {
        return ruleService.createRuleRes(ruleRes);
    }

    /**
     *
     * @param rule
     * @return
     */
    @RequestMapping(value = "/AddRule", method = RequestMethod.POST)
    public @ResponseBody
    String createRule(@RequestBody Rule rule) {
        if (ruleService.createRule(rule))
            return "Rule added";

        return "No new Rule has been added";
    }

    /**
     *
     * @param ruleId
     * @return
     */
    @RequestMapping(value = "/deleteRule/{ruleId}", method = RequestMethod.GET)
    public @ResponseBody
    String deleteRule( @PathVariable(value = "ruleId") int ruleId) {
        ruleService.deleteRule(ruleService.findRule(ruleId));
        return "Rule deleted";
    }
}

