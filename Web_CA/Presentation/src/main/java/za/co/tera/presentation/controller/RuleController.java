package za.co.tera.presentation.controller;

/**
 * Created by Laptop on 7/4/2014.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import za.co.tera.web_ca.business.Rule.base.RuleService;
import za.co.tera.web_ca.business.Rule.impl.RuleServiceImpl;
import za.co.tera.web_ca.domain.impl.Rule;

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
   }

