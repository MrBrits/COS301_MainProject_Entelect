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

        return "No new Rule has been added";
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

    @RequestMapping(value = "/getRuleNeighById", method = RequestMethod.POST)
    public @ResponseBody
    Ruleneighbours getRuleNeighById( @RequestBody int ruleNeighId) {
        return ruleService.findRuleNeigh(ruleNeighId);
    }
}

